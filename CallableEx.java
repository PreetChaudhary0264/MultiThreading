import java.util.concurrent.*;

public class CallableEx implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> task = new CallableEx();

        Future<String> result = executor.submit(task);
        System.out.println(result.get()); //blocking hota hai

        //.get(1, TimeUnit.SECONDS);  agar time me result nahi aaya → exception

        executor.shutdown();
    }
}
