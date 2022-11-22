import java.util.concurrent.Semaphore;

class thread1 extends Thread {

    Semaphore semaphore;
    char threadname;

    thread1(Semaphore semaphore, char name) {
        this.semaphore = semaphore;
        this.threadname = name;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            System.out.println("thread execustion started : " + threadname);
            System.out.println("lockis acuired by: " + threadname);
            System.out.println("locks available : " + semaphore.availablePermits());

            // critical section simulation

            for (int i = 0; i < 5; i++) {
                System.out.println("value of counter of: " + threadname + ' ' + i);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("thread execustion ended : " + threadname);
            System.out.println("lockis released by: " + threadname);
            semaphore.release();
            System.out.println("locks available: " + semaphore.availablePermits());

        }

    }
}

public class SemaphoreExp {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);
        thread1 t1 = new thread1(semaphore, 'A');
        thread1 t2 = new thread1(semaphore, 'B');
        thread1 t3 = new thread1(semaphore, 'C');
        t1.start();
        t2.start();
        t3.start();
    }
}