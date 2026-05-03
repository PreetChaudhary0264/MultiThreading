public class Volatilekeyword {
    public static void main(String[] args) {

        //it means changes to this variable are immediately are to all the thraeds
        //it prevents from caching the variables locally

        Thread t = new Thread(new Runnable(){
            public void run(){
                System.out.println("Hi");
            }
        });

        t.start();

        Thread t2 = new Thread(()->{
            System.out.println("Hi");
        });
        t2.start();

        //t and t2 both are same we can use either way
    }
}
