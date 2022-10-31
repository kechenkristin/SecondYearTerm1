import java.util.ArrayList;
import java.util.List;

public class NotifyTest {
    final Object lock = new Object();

    boolean  someoneWin = false;

    // list of players
    List<Player> players = new ArrayList<>();

    // methods to notify others if one player has won

   class Player implements Runnable {

        int count = 0;
        boolean win = false;

        Player() {
        }

        public void increCount() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + "thread count" + i);
                }
                if (count > 5) {
                    win = true;
                    someoneWin = true;
                    notifyAllPlayers();
                }
            }
        }

        @Override
        public void run() {
            synchronized (lock) {

                while (count <= 5) {
                    System.out.println("I am working");
                    increCount();
                }
                // wait();
            }
        }
    }

    public void notifyAllPlayers() {
        synchronized (lock) {
            if (someoneWin) {
                System.out.println("game over");
                // interrupt other threads
            }
        }
    }



    public static void main(String[] args) {
        NotifyTest thisObj = new NotifyTest();
        for (int i = 0; i < 4; i++) {
           // Thread pt = new Thread(NotifyTest.new Player(), String.valueOf(i));
           // if(someoneWin) {
                //notifyAllPlayers();
               // pt.stop();
            //}
          //  pt.start();
        }
        // notifyAllPlayers();


    }
}
