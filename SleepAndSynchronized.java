public class SleepAndSynchronized extends ThreadClass {

    @Override
    public synchronized void run() throws ArrayIndexOutOfBoundsException{   //thread class and runnables me hum sirf uncheck exceptions de skte hai, callable me checked aur unchecked dono de skte hai
        System.out.println(Thread.currentThread().getName() + " Thread started");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " Thread awaked after sleep");
    }

    public static void main(String[] args) {

//        SleepAndWait thread1 = new SleepAndWait();  //synchroniuzed global level pe lock nhi lgati wo object level pe lgati hai to aise to 2 onbjet bn gye and thread1, thread2 dono alag object hai to dono sath me enter kr jaynge run method me
//        SleepAndWait thread2 = new SleepAndWait();

//        Thread thread1 = new Thread();  aise krne se default run() mnethod chalega uper wala nhi to kuch kaam nhi krengi threads
//        Thread thread2 = new Thread();

        SleepAndSynchronized obj = new SleepAndSynchronized();

        //ab ek hi object bnaya ahai and same object hi pass kra hai dono threads me

        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);
        thread1.start();
        thread2.start();

        try{
            System.out.println("Main thread slept");
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Main thread awaked");
    }
}
