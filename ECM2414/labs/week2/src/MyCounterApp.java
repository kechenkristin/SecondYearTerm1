public class MyCounterApp {
    public static void main(String args[]) {
        final MyCounter a = new MyCounter();
        final Object lock = new Object();
        System.out.println("Current thread is :" + Thread.currentThread().getName());
        // thread inner class, will call addTwo on the My Counter instance
        // 1000 times
        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 1000; i++) {
                synchronized (lock) {
                    a.addTwo();
                }
                System.out.println("Value on thread 1 exit : " + a.countValue());
            }
        });

        // thread inner class, will call subtractTwo on the My Counter instance
        // 1000 times
        Thread t2 = new Thread(() -> {

            for (int i = 1; i <= 1000; i++) {
                synchronized (lock) {
                    a.subtractTwo();
                }
                System.out.println("Value on thread 2 exit:" + a.countValue());
            }
        });

        t1.start();
        t2.start();
    }
}
