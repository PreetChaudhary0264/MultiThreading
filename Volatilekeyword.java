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


        //volatile kayword ka ek exampel dedo jisme ek counter hoga and jab tak while loop run hoga counter++;
//        while(running){
//            countrr++;
//        }
//
//        and then main thread aake isko false kr dei unnignko then ye immediately sbhi thereads ke liye false ho jayga
    }
}
