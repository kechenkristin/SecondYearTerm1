public class ThreadExample4 {

    public static void main(String[] args) {
        // implement java runnable interface with lambda expression
        Runnable myRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("The name of the thread is : " + threadName);
        };

        Thread thread1 = new Thread(myRunnable, "thread1");
        thread1.start();

        Thread thread2 = new Thread(myRunnable, "thread2");
        thread2.start();
    }
}
