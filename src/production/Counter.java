package production;

public class Counter {
    private long counter;

    public Counter(long counter) {
        this.counter = counter;
    }

    public synchronized void decrementCounter() {
        counter--;
    }
    public synchronized long getCounter() {
        return counter;
    }
}
