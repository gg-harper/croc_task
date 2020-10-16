package production;

public class Consumer implements Runnable {   // implements Runnable interface to allow usage of multi-threading
    Product product;
    Storage storage;
    Counter counter;

    public Consumer(Product product, Storage storage, Counter counter) {
        this.product = product;
        this.storage = storage;
        this.counter = counter;
    }

    @Override
    public void run() {
        String data = "";
        while (counter.getCounter() > 0) {
           /* try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {}*/
            data = product.get();               // get data from temporary storage of product
            storage.output(data);                    // output data to file
           // System.out.println(counter.getCounter());
            counter.decrementCounter();
        }
    }
}
