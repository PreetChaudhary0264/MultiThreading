import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksEx {
    private int counter = 0;

    //one thread that is holding the lock can reaquire the lock without causing the deadlock
    final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired lock on counter " + counter);
            counter++;
        }finally{
            System.out.println(Thread.currentThread().getName() + " released lock on counter " + counter);
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLocksEx obj = new ReentrantLocksEx();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 0;i < 5; i++){
            executor.submit(()-> obj.increment());
        }
        executor.shutdown();
    }
}
