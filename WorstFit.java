import java.util.HashMap;
import java.util.Map;

public class WorstFit {

    public static int MemoryBlocks[] = new int[] { 25, 40, 100, 85, 10 };

    public static int ProcessSize[] = new int[] { 10, 15, 110, 75, 40, 50 };

    // will make a key value pair structure to hold the process id and block id
    // e.g 1 : 2 -> means process id 1 is allocated to block 2
    public static HashMap<Integer, Integer> ProcessMap = new HashMap<Integer, Integer>();

    // will make a key value pair structure to hold memory id and process it has
    // been allocated to
    public static HashMap<Integer, Integer> MemoryMap = new HashMap<Integer, Integer>();

    // will search for the first hole which is bigger than the size
    public static void BestFitAlloc(int id) {

        int currentPSize = ProcessSize[id];
        int MaxFragmentSize = Integer.MIN_VALUE;
        int MaxFragID = -1;

        for (int i = 0; i < MemoryBlocks.length; i++) {
            
            if (MemoryBlocks[i] >= currentPSize && MemoryMap.get(i) == -1) {
                // find a block with greater size and not been yet allocated a process
                // try to find the fragment if process is added
                int fragment = MemoryBlocks[i] - currentPSize;
                // just find the block with maximum fragment
                if (fragment > MaxFragmentSize) {
                    MaxFragmentSize = fragment;
                    MaxFragID = i;
                }
            }
        }

        if (MaxFragID != -1) {
            ProcessMap.put(id, MaxFragID);
            MemoryMap.put(MaxFragID, id);
        }
    }

    public static void main(String[] args) {

        // initially no process is allocated to each block
        MemoryMap.put(0, -1);
        MemoryMap.put(1, -1);
        MemoryMap.put(2, -1);
        MemoryMap.put(3, -1);
        MemoryMap.put(4, -1);

        for (int i = 0; i < ProcessSize.length; i++) {
            // no block is allocated to process size with id i
            ProcessMap.put(i, -1);
            // send each process id to find the suitable block
            BestFitAlloc(i);
        }

        for (Map.Entry<Integer, Integer> Hmap : ProcessMap.entrySet()) {
            int Process_ID = Hmap.getKey();
            int Block_ID = Hmap.getValue();

            if (Block_ID != -1) {
                System.out.println("Process ID - " + Process_ID + " Process Size - " + ProcessSize[Process_ID]
                        + " Block ID - " + Block_ID + " Block Size " + MemoryBlocks[Block_ID]);
            } else {
                System.out.println("Process ID - " + Process_ID + " Process Size - " + ProcessSize[Process_ID]
                        + " Block ID - " + Block_ID + " Block Size " + " No Block Allocated :(");

            }
        }

    }
}
