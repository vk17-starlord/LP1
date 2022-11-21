import java.util.*;

public class priority_np{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes");
        int n = sc.nextInt();

        int processID[] = new int[n];
        int arrivalT[] = new int[n];
        int priorityA[] = new int[n];
        int burstT[] = new int[n];
        int completionT[] = new int[n];
        int turnaroundT[] = new int[n];
        int waitingT[] = new int[n];
        int temp=0;
        float avgTat=0;
        float avgWt=0;

        for(int i=0; i<n; i++){

            processID[i] = i+1;
            System.out.println("Enter the arrival time of process "+(i+1));
            arrivalT[i] = sc.nextInt();
            System.out.println("Enter the burst time of process "+(i+1));
            burstT[i] = sc.nextInt();
            System.out.println("Enter the priority of process "+(i+1));
            priorityA[i] = sc.nextInt();

        }

        for(int i=0; i<n; i++){

            for(int j=0; j<n-(i+1); j++){

                if(priorityA[j] > priorityA[j+1]){

                    temp = priorityA[j];
                    priorityA[j] = priorityA[j+1];
                    priorityA[j+1] = temp;

                    temp = burstT[j];
                    burstT[j] = burstT[j+1];
                    burstT[j+1] = temp;

                    temp = arrivalT[j];
                    arrivalT[j] = arrivalT[j+1];
                    arrivalT[j+1] = temp;

                    temp = processID[j];
                    processID[j] = processID[j+1];
                    processID[j+1] = temp;

                }
            }
        }


        for(int i=0; i<n; i++){

            if(i==0){
                completionT[i] = arrivalT[i] + burstT[i];
            }
            else if(arrivalT[i] > completionT[i-1]){
                completionT[i] = arrivalT[i] + burstT[i];    
            }
            else{
                completionT[i] = completionT[i-1] + burstT[i];
            }

            turnaroundT[i] = completionT[i]-arrivalT[i];
            waitingT[i] = turnaroundT[i]-burstT[i];
            avgTat += turnaroundT[i];
            avgWt += waitingT[i];
        }

        System.out.println("\npid at bt pri ct tat wt");

        for(int i=0; i<n; i++){
            System.out.println(processID[i]+"\t"+arrivalT[i]+"\t"+burstT[i]+"\t"+priorityA[i]+"\t"+completionT[i]+"\t"+turnaroundT[i]+"\t"+waitingT[i]);
        }

        System.out.println("Average waiting time: "+(avgWt/n));
        System.out.println("Average turnaround time: "+(avgTat/n));

    }
}