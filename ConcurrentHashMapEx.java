import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> mpp = new ConcurrentHashMap<>();

        Thread t1 = new Thread(()->{
            for(int i = 0; i < 5; i++){
                mpp.put(i,1);
            }
        });
        Thread t2 = new Thread(()->{
            for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
                System.out.println("key " + entry.getKey() + " value " + entry.getValue());
            }
        });

        t1.start();
        t2.start();
    }
}

//normal map me multithreading me hme pura map lock krna pdega but concurrentMap me hum buckets(keys) ko lock krte hai basically agar 16 buckets hai to 16 threads can write simultaneously at corresponding bucket