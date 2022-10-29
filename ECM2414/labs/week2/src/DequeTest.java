import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DequeTest {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        Deque<Integer> unsafeDeque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
            unsafeDeque.add(1);
            }).start();
        }

        System.out.println(unsafeDeque);
    }
}
