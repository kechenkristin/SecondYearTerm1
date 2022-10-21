public class SimpleThreads
{
    public static void main (String[] args) {
        MyRunnable r = new MyRunnable();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        r.run();                // what's going on here?
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println( "Horah for threads, says " 
                  + Thread.currentThread().getName() );
    }

}
/* You may have noticed I have multiple classes in the same file 
 * which are not nested. This is legal, but you may only have one 
 * public class in a file (which should have the same name as the 
 * file) */