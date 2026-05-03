public class SynchronizedKeyword {
    final Object lock = new Object();
    public static void main(String[] args) {
        //ye objects instacnce pe lock acquire krta hai

        //code to aata hi hai likhne ki zarurat nhi

        //ye hai static content pe lock lgane ke liye we use class name.class
        //class level lock
        synchronized (SynchronizedKeyword.class){
            //critical content
        }
    }

    public void test(){
        //lock obj pe lock lga diya
        synchronized (lock){
            //critical content
        }

        //this is instance based lock(current instance pe lock)
        synchronized (this){
            //critical content
        }
    }
}
