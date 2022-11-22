import java.util.HashMap;
import java.util.Map;

public class NextFit {

    public static int MemoryBlocks[] = new int[] { 25, 40, 100, 85, 10 };

    public static int ProcessSize[] = new int[] { 10, 15, 110, 75, 40, 50 };

    // will make a key value pair structure to hold the process id and block id
    // e.g 1 : 2 -> means process id 1 is allocated to block 2
    public static HashMap<Integer, Integer> ProcessMap = new HashMap<Integer, Integer>();

    // will make a key value pair structure to hold memory id and process it has
    // been allocated to
    public static HashMap<Integer, Integer> MemoryMap = new HashMap<Integer, Integer>();

    public static Integer cache_pointer = 0;

    public static void NextFitAlloc(int id) {
        System.out.println("starting search from - " + cache_pointer);
        int currentPSize = ProcessSize[id];

        int count = 0;

        while (count != MemoryBlocks.length - 1) {

            if (MemoryBlocks[cache_pointer] > currentPSize
                    && MemoryMap.get(cache_pointer) == -1) {

                ProcessMap.put(id, cache_pointer);
                MemoryMap.put(cache_pointer, id);

                return;
            }

            cache_pointer = (cache_pointer + 1) % MemoryBlocks.length;
            System.out.println(cache_pointer);
            count++;
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
            NextFitAlloc(i);
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
