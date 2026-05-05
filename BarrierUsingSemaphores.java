import java.util.concurrent.Semaphore;

public class BarrierUsingSemaphores {

    //hum 5 threads leke chl rhe hai islye count 5 liya
    int count  = 5;
    int dCount = 5;
    private static final Semaphore mutex = new Semaphore(1);
    private static final Semaphore barrier = new Semaphore(0);

    public void await() throws InterruptedException {
        mutex.acquire();
        count--;

        if(count == 0){  //yani last thread hai
            barrier.release(dCount-1);  //ye last thread haia nd baali 5 thread stuck hai line 20 pe to isne 5-1=4 permits ko add kr diya semaphore me ab wo threads acquire kr lengi and line 20 se release ho jayngi
            count = dCount;   //wapas se count ko 5 set krdo
            mutex.release();  //last thread ko bhi release krdo
        }else{
            mutex.release();
            barrier.acquire();   //permits 0 hai to thread yhi pe stuck ho jaygi
        }
    }  //ab saari threads release ho gyi

    public static void main(String[] args) throws InterruptedException {
        BarrierUsingSemaphores obj = new BarrierUsingSemaphores();

        //perform some task

        obj.await();   //yani jab tak saari threads ka kaam khtm nhi ho jata to is line se aage koi bhi nhi badh payga


    }
}

//we can also perform read and write lock like reentrantReadWriteLock using semaphores...
//take ex of 2 readers and 1 writer
