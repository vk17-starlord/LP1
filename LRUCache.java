
import java.util.*;

public class LRUCache {

    public static LinkedList<Integer> Frame = new LinkedList<Integer>();
    public static int refArr[] = new int[] { 0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1 };

    public static Integer MaxFrameSize = 4;
    public static Integer pageFault = 0;
    public static Integer pageHit = 0;

    public static void replaceLRU(int ref, int index) {

        int Maxdistance = Integer.MIN_VALUE;
        int farElement = refArr[index];
        System.out.println(index + "= Index");

        for (int i = 0; i < Frame.size(); i++) {
            int currentElement = Frame.get(i);
            int Pointer = index;
            int currDistance = 0;
            while (Pointer >= 0) {
                if (refArr[Pointer] == currentElement) {
                    currDistance = index - Pointer;
                    break;
                }
                Pointer--;
            }
            if (Maxdistance < currDistance) {
                Maxdistance = currDistance;
                farElement = i;
            }
        }
        Frame.set(farElement, ref);
    }

    public static void RequestFrame(int ref, int index) {
        // search for ref in the frame

        if (Frame.contains(ref)) {
            // page hit occurrd
            pageHit = pageHit + 1;

            return;
        }
        // page fault occured
        pageFault = pageFault + 1;

        if (Frame.size() < MaxFrameSize) {
            // add it in frame if space is available
            Frame.add(ref);
            return;

        } else {
            // remove LRU page from frame
            replaceLRU(ref, index);
            return;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < refArr.length; i++) {
            RequestFrame(refArr[i], i);
        }

        System.out.println("Page Fault - " + pageFault);
        System.out.println("Page Hit - " + pageHit);
        System.out.println(Frame);
    }
}