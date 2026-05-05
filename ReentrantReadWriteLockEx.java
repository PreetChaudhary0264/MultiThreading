import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockEx {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    int logValue = 0;

    public void readValue(){
        lock.readLock().lock();

        System.out.println(Thread.currentThread().getName() + " acquired read lock ");
        System.out.println(Thread.currentThread().getName() + " read logvalue " + logValue);
        System.out.println(Thread.currentThread().getName() + " released read lock ");

        lock.readLock().unlock();
    }

    public void writeValue(){
        lock.writeLock().lock();

        System.out.println(Thread.currentThread().getName() + " acquired write lock ");
        logValue = logValue+1;
        System.out.println(Thread.currentThread().getName() + " updated logvalue to " + logValue);
        System.out.println(Thread.currentThread().getName() + " released write lock ");

        lock.writeLock().unlock();
    }

    public void readThenWrite() {
        // READ PHASE
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired read lock");
            System.out.println(Thread.currentThread().getName() + " read logValue " + logValue);
        } finally {
            System.out.println(Thread.currentThread().getName() + " released read lock");
            lock.readLock().unlock();
        }

        // WRITE PHASE
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired write lock");
            logValue = logValue + 1;
            System.out.println(Thread.currentThread().getName() + " updated logValue to " + logValue);
        } finally {
            System.out.println(Thread.currentThread().getName() + " released write lock");
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockEx obj = new ReentrantReadWriteLockEx();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //SEPERATED READ WRITE FLOW

//        executor.execute(()-> obj.readValue());
//        executor.execute(()-> obj.readValue());
//
//        executor.execute(()-> obj.writeValue());
//        executor.execute(()-> obj.writeValue());
//        executor.execute(()-> obj.readValue());
//        executor.execute(()-> obj.readValue());

        //MIXED FLOW

        executor.execute(()-> obj.readThenWrite());
        executor.execute(()-> obj.readThenWrite());
        executor.execute(()-> obj.readValue());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        executor.shutdown();
    }
}

//Case1  => Reading
//Thread-1 → readLock ✅
//Thread-2 → readLock ✅
//Thread-3 → readLock ✅

//Case2 => Writing
//Thread-1 → writeLock ✅
//Thread-2 → ❌ blocked
//Thread-3 → ❌ blocked

//Case3 => Mixed
//Thread-1 → readLock
//Thread-2 → writeLock ❌ (blocked)