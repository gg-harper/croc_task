package production;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{    // Runnable for multi-threading
    private Product product;
    private Counter counter;

    public Producer(Product product, Counter counter) {
        this.product = product;
        this.counter = counter;
        this.counter = counter;

    }
    @Override
    public void run() {
        while (counter.getCounter() > 0) {
            product.put();// put data to temp storage
            counter.decrementCounter();
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}*/
        }

    }
}
