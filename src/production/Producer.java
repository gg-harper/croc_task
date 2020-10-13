package production;

import java.util.Date;
import java.util.Random;

public class Producer implements Runnable{    // Runnable for multi-threading
   private Product product;
    private volatile  int counter;
    Date date = new Date();                   // date object to seed random
    Random random = new Random(date.getTime()); //random object generate data

    public Producer(Product product, int counter) {
        this.product = product;
        this.counter = counter;

    }
    @Override
    public void run() {
        while(counter >= 0) {
            product.put(random.nextInt(127)); // put data to temp storage
            counter--;
        }

    }
}
