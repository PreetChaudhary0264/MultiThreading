public class ThreadClass extends Thread {

    @Override
    public void run() throws ArrayIndexOutOfBoundsException{   //thread class and runnables me hum sirf uncheck exceptions de skte hai, callable me checked aur unchecked dono de skte hai
        System.out.println("Thread started");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Thread awaked after sleep");
    }
    public static void main(String[] args) {
        ThreadClass thread1 = new ThreadClass();
        thread1.start();

        try{
            System.out.println("Main thread slept");
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Main thread awaked");
    }
}
