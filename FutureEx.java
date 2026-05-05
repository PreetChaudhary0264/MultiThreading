import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //same hai jo maine abi padha hai
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(()-> 1);

//        System.out.println(future.get());   it is a blcoking call

        if(future.isDone()){   //non-blocking call
            System.out.println("TaskCompleted");
        }
        if(future.isCancelled()){   //non-blocking call
            System.out.println("Future cancelled");
        }

        //now to cancel future

        Future<Integer> future2 = executor.submit(()-> {
            while(true){   //check krte rhna pdega ki task cancel kra hai kisine?
                if(Thread.interrupted()){
                    System.out.println("Task was interupped . stopping");
                }
            }


            //do task
        });

        future2.cancel(true);   //sends interrupt.........ye Thread.interupped ko true mark krta hai
    }
}


//Limitations of future

//1. no chaining (multiple tasks together)   (task2 will dependent on task1 completion)
//2. no exception handling
//3. Blocking operations

//lets say task2 dependent hai task1 prr to task1 ke baad .get() and task2 ke baad .get() lgana pdega
//isliye completiable fulture me hum chain kr skte haia and last me ek hi .get() se ho jayga