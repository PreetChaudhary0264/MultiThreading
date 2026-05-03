public class WaitEX implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try{
            wait();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }

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

//        for (int i = 0; i < 5; i++) {
//            WaitEX obj = new WaitEX();
//
//            Thread t1 = new Thread(obj);
//            Thread t2 = new Thread(obj);
//
//            t1.start();
//            t2.start();
//
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e) {}
//
//            synchronized (obj) {
//                obj.notifyAll();
//            }
//
//            System.out.println("----- iteration done -----");
//        }
    }
}
