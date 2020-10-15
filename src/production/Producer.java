package production;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{    // Runnable for multi-threading
    private Product product;
    private volatile  int counter;

    public Producer(Product product, int counter) {
        this.product = product;
        this.counter = counter;

    }
    @Override
    public void run() {
        while (true) {
            product.put();// put data to temp storage
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }

    }
}
