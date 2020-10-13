package production;

public class Consumer implements Runnable {   // implements Runnable interface to allow usage of multi-threading
    Product product;
    Storage storage;
    private static int counter;// operation counter, we set it in main

    public Consumer(Product product, Storage storage, int counter) {
        this.product = product;
        this.storage = storage;
        this.counter = counter;
    }

    @Override
    public void run() {
        int data = 0;
        while(Consumer.counter >= 0) {
            data = product.get(data);               // get data from temporary storage of product
            storage.output(data);                    // output data to file
            System.out.println();
            Consumer.counter--;
        }
    }
}
