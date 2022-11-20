import java.util.*;

public class BestFit {
    public static HashMap<Integer, Integer> MemoryBlock = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> ProcessID = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> ProcessBlock = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> MemoryID = new HashMap<Integer, Integer>();

    public static void SearchHole(int pid, int pspace) {
        // iterate over memory block and assign memory block where space is more than
        // process size

        int minFragment = Integer.MAX_VALUE;
        int minFragmentID = -1;

        for (Map.Entry<Integer, Integer> entry : MemoryBlock.entrySet()) {
            int mid = entry.getKey();
            int msize = entry.getValue();

            if (pspace < msize && MemoryID.get(mid) == -1) {
                if (minFragment > msize - pspace) {
                    minFragment = msize - pspace;
                    minFragmentID = mid;
                }
            } 

        }

        ProcessID.put(pid, minFragmentID);
        MemoryID.put(minFragmentID, pid);

    }

    public static void print() {
        for (Map.Entry<Integer, Integer> entry : ProcessID.entrySet()) {
             int pid = entry.getKey();
             int block = entry.getValue();
             System.out.println("Process ID - "+pid+" Process Size - "+ProcessBlock.get(pid)+" Block Allocated - "+ block );
        }
    }

    public static void BestFitAlloc() {
        // iterate over all the process and find the hole in memory block
        for (Map.Entry<Integer, Integer> process : ProcessBlock.entrySet()) {
            SearchHole(process.getKey(), process.getValue());
        }
    }

    public static void main(String[] args) {

        ProcessBlock.put(1, 212);
        ProcessBlock.put(2, 417);
        ProcessBlock.put(3, 112);
        ProcessBlock.put(4, 426);

        ProcessID.put(1, -1);
        ProcessID.put(2, -1);
        ProcessID.put(3, -1);
        ProcessID.put(4, -1);

        MemoryBlock.put(1, 100);
        MemoryBlock.put(2, 200);
        MemoryBlock.put(3, 300);
        MemoryBlock.put(4, 250);
        MemoryBlock.put(5, 600);

        MemoryID.put(1, -1);
        MemoryID.put(2, -1);
        MemoryID.put(3, -1);
        MemoryID.put(4, -1);
        MemoryID.put(5, -1);

        // iterate over process block and search for empty space
        BestFitAlloc();

        print();
    }

}