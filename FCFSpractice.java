public class FCFSpractice {

    public static void calculate(int at[], int bt[], int wt[], int ct[], int tat[]) {

        // inital first value of process
        wt[0] = 0;
        ct[0] = bt[0];
        tat[0] = bt[0];

        for (int i = 1; i < at.length; i++) {
            int hold;
            if (at[i] < ct[i - 1]) {
                hold = ct[i - 1] - at[i];
            } else {
                hold = 0;
            }
            ct[i] = at[i] + bt[i] + +hold;
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

    }

    public static void main(String[] args) {
        int pid[] = new int[] { 1, 2, 3, 4};
        int at[] = new int[] { 0,1,5,6};
        int bt[] = new int[] { 2,2,3,4 };
        int ct[] = new int[5];
        int tat[] = new int[5];
        int wt[] = new int[5];

        // sort the input according to the at

        for (int i = 0; i < pid.length; i++) {
            for (int j = i + 1; j < pid.length; j++) {
                int temp = 0;
                if (at[i] > at[j]) {
                    temp = at[i];
                    at[i] = at[j];
                    at[j] = temp;

                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                }
                if(at[i] == at[j]){
                    System.out.println(pid[i] +""+ pid[j]);
                }
            }
        }

        calculate(at, bt, wt, ct, tat);

        for (int i = 0; i < at.length; i++) {
            System.out.println(
                    " PID - " + pid[i] + " AT - " + at[i] + " BT - " + bt[i] + " WT - " + wt[i] + " TAT - " + tat[i]
                            + " CT - " + ct[i]);
        }
    }
}
