public class WaitEX implements Runnable {
    private final Object lock = new Object();

    Object getLock(){
        return lock;
    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try{
            wait();  //this.wait();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    //notify and wait synchronized block ke ander hi hote hai
    //wait and notify Object class ke methods hai to inhe kisi bhi object se run kra ja skta hai jsie main WaitEx ke obj se notify ko run krra hu
    //ya fir seperate obj use krlo agar multiple threads ke sath share krna hai to
    //Object lock = new Object();

    public static void main(String[] args) {
        WaitEX obj = new WaitEX();
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

        synchronized (obj){
            obj.notifyAll();
        }

//        synchronized (obj.lock){
//            obj.lock.notify();
//        }

//        synchronized(obj) {
//            // koi aur code
//        }     agar kisi aur ne bhi obj pe lock le liya
                //→ tera thread block ho sakta hai unexpectedly
    }
}
