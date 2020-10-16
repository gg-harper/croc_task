package production;

public class Consumer implements Runnable {   // implements Runnable interface to allow usage of multi-threading
    Product product;
    Storage storage;

    public Consumer(Product product, Storage storage) {
        this.product = product;
        this.storage = storage;
    }

    @Override
    public void run() {
        String data = "";
        while (true) {
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {}
            data = product.get();               // get data from temporary storage of product
            storage.output(data);                    // output data to file
        }
    }
}
