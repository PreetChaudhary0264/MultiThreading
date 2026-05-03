public class ModernWay {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("Thread started");
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Thread awaked after sleep");
        });

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
