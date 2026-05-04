import java.util.concurrent.atomic.AtomicInteger;

public class AtomicKeyword {
    AtomicInteger counter = new AtomicInteger(0);


    //Atomic variable me locks ka use kiya bina sbhi threads same latest value share krti hai
    public void increment(){
        int newCounter = counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " incremented counter to " + newCounter);
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicKeyword obj = new AtomicKeyword();

        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.increment();
                }
            });
            threads[i].start();
        }

        for(int i = 0; i < 5; i++){
            threads[i].join();
        }
    }
}
