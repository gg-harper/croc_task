package production;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Product {
    private Queue<String> temporaryStorage = new ConcurrentLinkedQueue<>();    // queue for temporary data storage
    void put() {
        temporaryStorage.offer("produced by " + Thread.currentThread().getName());
    }
    String get() {
        String data = "";
        if(!temporaryStorage.isEmpty()) {
            data = temporaryStorage.remove();
        }
        return data;
    }
}
