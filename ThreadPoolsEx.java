import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolsEx extends Thread {  //Thread class bhi Runnable ko implement krte hai to ThreadPoolEx bhi runnable hi hua tbhi tum executor.execute(new ThreadPoolEx) call krte ho to wo valid hai
    int task;

    ThreadPoolsEx(int task){
        this.task = task;
    }
    @Override
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + " executing task " + task);
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished task " + task);
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 5; i++){
            executor.execute(new ThreadPoolsEx(i));  //runnable expect krta hai and yha ThreadPoolEx runnable hi smjho bcoz wo extends krta hai Thread Class ko and ThreadClass implements Runnable
        }

        executor.shutdown();
    }
}



// newCachedThreadPool => basically ye dynammically threads create krta hai
// ThreadPoolExecutor => ye dono ka mixture hai
                        // isme coreThreadSize hota hai ki initially itni threads pool me rhenge
                        //ek queue bhi hoti hai jisme task queued hote hai jab ye queue full ho jati hai to ye poolSize hota hai yani itni threads hum dynammically bna kste hai
                        // ab baaki bchi requests ko handle kr skte hai ya fir drop
