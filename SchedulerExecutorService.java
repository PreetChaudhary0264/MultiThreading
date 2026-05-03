import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorService {
    public static void main(String[] args) {
        //tasks ko schedule krne ke liye use krte hai, ya fir delay add krne ke liye

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        scheduler.schedule(()-> {
            System.out.println("3 Sec ke baad ye task run hoga");
        },3, TimeUnit.SECONDS);   //isme delay seconds ke baad ye task execute hoga

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("hr 2 sec me run hoga ye task");
        },0,2,TimeUnit.SECONDS);  //isme initial delay 0 hai and hr 2 sec me tak execute hoga,
        //lekin maanloe task ko khtm hone me 4s lg gyi and 2 sec pe task dobara execute hona tha but thread busy thii to nhi ho paya to ab jab ye task finish hoga uske immediately yani 4s pe hi dobara task execute hoga
        //basically ye cover krne ki koshish krega

        scheduler.scheduleWithFixedDelay(()->{
            System.out.println("Task khtm hone ke baad 2 sec ke baad suru hoga");
        },0,2,TimeUnit.SECONDS);   //isme initial delay 0 hai and task finish hone ke baad 2 sec ka gap and then again ye task execute hoga

        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        scheduler.shutdown();
    }
}
