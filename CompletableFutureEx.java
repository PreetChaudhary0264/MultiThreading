import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {
    public static void main(String[] args) {

        //This is tasks chaining
        CompletableFuture.supplyAsync(()->{
            //some task
            return "hi";
        }).thenAccept(result -> {
            //some task
        });


        //.get() function same as future
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> "hi");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()-> "hi");

        future.complete("Manual completed");//this is used when u want to complete a future manually
        //if task is already completed then complete() returns false;
        System.out.println(future.join());  //output => Manual completed
        //i production .get() is used instead of .join()   ,in join we dont need to write rry catch thats why we are using here

        //isDone();  same as Future
        //supplyAsync()    same as Future ka submit
        //thenApply()     for chaining
        //thenApplyAsync     ye us task ko async process krega on a seperate thread


        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()-> "hello");

        //.thenCombine is used to combine the res of 2 futures
        CompletableFuture<String> combined = future1.thenCombine(future2,
                (res1,res2) -> res1 + res2);

        System.out.println(combined.join());


        //.allOf   wait for all furtures to complete
        CompletableFuture<Void> all = CompletableFuture.allOf(future2,future1);
        all.thenRun(()-> System.out.println("All task completed"));

        //.anyOf     wait for any futures to compelete
        CompletableFuture<Object> any = CompletableFuture.anyOf(future2,future1);
        any.thenRun(()-> System.out.println("All task completed"));


        //.exceptionally
        CompletableFuture<String> f = CompletableFuture.supplyAsync(()-> "hi")
                .exceptionallyCompose(ex ->  {
                    System.out.println(ex.getMessage());

                    return null;
                });


        //.handle    for handling success and failure
        CompletableFuture<String> fu = CompletableFuture.supplyAsync(()-> "hi")
                .handle((res,ex) -> {
                    System.out.println(res);
                    return res;
                });
    }
}
