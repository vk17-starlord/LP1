
import java.util.concurrent.Semaphore;


class MyAtmThread extends Thread {
    Semaphore semaphore;
    String name;

    MyAtmThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            System.out.println(name + " Acquired lock ");
            System.out.println("Available Permits are - " + semaphore.availablePermits());

            for(int i=0 ; i<5 ; i++){
                System.out.println(name+" is executing task number - "+i);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
 
            System.out.println("It is now releasing the lock");
            semaphore.release();
            System.out.println("Available Locks are - "+ semaphore.availablePermits());
      
        }
    }

}


public class SemaphorePractice {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        
        MyAtmThread t1 = new MyAtmThread(semaphore, "vinit");
        MyAtmThread t2 = new MyAtmThread(semaphore, "pranit");
        MyAtmThread t3 = new MyAtmThread(semaphore, "rohan");

        t1.start();
        t2.start();
        t3.start();
    
    }
}
