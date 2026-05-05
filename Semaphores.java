import java.util.concurrent.Semaphore;

public class Semaphores {
    private static final Semaphore mutex = new Semaphore(1);

    public static void test(String threadName){
        try{
            System.out.println(threadName + " trying to acquire the lock");
            mutex.acquire();
            System.out.println(threadName + " acquired the lock at" + System.nanoTime());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }finally {
            mutex.release();
            System.out.println(threadName + " released the lock at " + System.nanoTime()); //is line ko koi bhi thread kisi bhi order me execute kr skti hai bcoz lock sirf uper wali line tak lga hai
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> test("thread-1"));
        Thread t2 = new Thread(()-> test("thread-2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
