import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorService {
    public static void main(String[] args) {
        //tasks ko schedule krne ke liye use krte hai, ya fir delay add krne ke liye

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        scheduler.schedule(()-> {
            System.out.println("3 Sec ke baad ye task run hoga");
        },3, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("hr 2 sec me run hoga ye task");
        },0,2,TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(()->{
            System.out.println("Task khtm hone ke baad 2 sec ke baad suru hoga");
        },0,2,TimeUnit.SECONDS);

        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        scheduler.shutdown();
    }
}
