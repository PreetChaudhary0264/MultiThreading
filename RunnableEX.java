public class RunnableEX implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread started");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Thread awaked after sleep");
    }

    public static void main(String[] args) {

        Runnable runnable = new RunnableEX();
        Thread thread = new Thread(runnable);
        thread.start();

        try{
            System.out.println("Main thread slept");
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Main thread awaked");
    }
}
