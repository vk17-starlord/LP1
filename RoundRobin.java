import java.util.*;

public class RoundRobin {
    public static HashMap<Integer, Integer> PID = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> AT = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> BT = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> WT = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> CT = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> TAT = new HashMap<Integer, Integer>();
    public static Queue<Integer> readyqueue = new LinkedList<Integer>();
    public static LinkedHashMap<Integer, Integer> SORTEDAT = new LinkedHashMap<Integer, Integer>();

    public static void PrintChart() {

        for (Map.Entry<Integer, Integer> entry : PID.entrySet()) {
            System.out.println(
                    "PID - " + entry.getKey() +
                            " AT - " + AT.get(entry.getKey()) +
                            " BT - " + BT.get(entry.getKey()) +
                            " CT - " + CT.get(entry.getKey()) +
                            " TAT - " + TAT.get(entry.getKey()) +
                            " WT - " + WT.get(entry.getKey()));
        }

    }

    public static boolean isEveryProcessExecuted() {

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : PID.entrySet()) {

            if (entry.getValue() == 1) {
                count++;
            }

        }

        return count == PID.size();
    }

    public static void GanttChart(int Quantam) {

    }

    public static void SortByArrival() {

        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : AT.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<Integer, Integer> entry : AT.entrySet()) {
                if (entry.getValue().equals(num)) {
                    SORTEDAT.put(entry.getKey(), num);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Time Quantam");
        int Quantam = sc.nextInt();

        PID.put(1, 0);
        PID.put(2, 0);
        PID.put(3, 0);
        PID.put(4, 0);

        // FILL ALL THE AT ALONG WITH KEY PID
        AT.put(1, 0);
        AT.put(2, 1);
        AT.put(3, 2);
        AT.put(4, 4);

        // FILL ALL THE BT ALONG WITH KEY PID

        BT.put(1, 5);
        BT.put(2, 4);
        BT.put(3, 2);
        BT.put(4, 1);
        SortByArrival();
        GanttChart(Quantam);
        PrintChart();
        sc.close();
    }
}
