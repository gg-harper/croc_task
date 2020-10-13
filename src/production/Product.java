package production;

import java.util.ArrayDeque;
import java.util.Queue;

public class Product {
    private Queue<Integer> temporaryStorage = new ArrayDeque<>();           // queue for temporary data storage
    synchronized void put(int data) {
    /*    try {
            wait();
        }
        catch (InterruptedException e) {
        }*/
       // notifyAll();
        temporaryStorage.offer(data);                               //put produced data to storage
    }
    synchronized int get(int data) {
        while(temporaryStorage.isEmpty()) {                         // if queue is empty - wait
            try {
                wait();
            }
            catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        }
            data = temporaryStorage.poll();                             // get info from  temporary storage
            notify();
        return data;
    }
}
