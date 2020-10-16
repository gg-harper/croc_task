package production;

public class Producer implements Runnable{    // Runnable for multi-threading
    private Product product;

    public Producer(Product product) {
        this.product = product;

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
