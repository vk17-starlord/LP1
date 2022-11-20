public class FCFS {

    public static void calculate(int at[], int bt[], int wt[], int tat[], int ct[]) {

        wt[0] = 0;
        ct[0] = bt[0];
        tat[0] = bt[0];

        for (int i = 1; i < at.length; i++) {
            int hold = 0;
            if (ct[i - 1] > at[i]) {
                hold = ct[i - 1] + at[i];
            } else {
                hold = 0;
            }

            ct[i] = at[i] + bt[i] + hold;
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

    }

    public static void main(String[] args) {

        int pid[] = new int[] { 1, 2, 3, 4, 5 };
        int at[] = new int[] { 0, 1, 5, 6 };
        int bt[] = new int[] { 2, 2, 3, 4 };

        int wt[] = new int[pid.length];

        int ct[] = new int[pid.length];

        int tat[] = new int[pid.length];

        calculate(at, bt, wt, tat, ct);

        for (int i = 0; i < at.length; i++) {
            System.out.println(
                    " PID - " + pid[i] + " AT - " + at[i] + " BT - " + bt[i] + " WT - " + wt[i] + " TAT - " + tat[i]
                            + " CT - " + ct[i]);
        }
    }
}
