public class MyCounter {
    private int count = 0;

    private final Object lock = new Object();

    public void addTwo() {
        this.count += 2;
        // System.out.println("Value: " + count);
        // retrieve counter, change counter, store counter
    }

    public void subtractTwo() {
        this.count -= 2;
        // System.out.println("Value: " + count);
    }

    public synchronized int countValue() {
        return this.count;
    }
}
