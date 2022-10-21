import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class PC {
    static class Item {
        private Integer val;

        public Item(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return this.val;
        }
    }

    LinkedList<Item> list = new LinkedList<>();
    int capacity = 2;

    /*
    producer put items in the list
     */
    public void produce(Integer itemVal) throws InterruptedException {
        synchronized (list) {
            while (list.size() == capacity) {
                System.out.println("The list is full now, producer could not put item in it!");
                list.wait();
            }
            list.addLast(new Item(itemVal));
            System.out.println("The " + Thread.currentThread().getName() +" now put an item "+ itemVal +" in to the list.");
            list.notifyAll();
            sleep(1000);
        }
    }

    /**
     * consumer take item from the list
     *
     * @throws InterruptedException
     */
    public void consume() throws InterruptedException {
        synchronized (list) {
            while (list.isEmpty()) {
                System.out.println("The list is empty now, the consumer could not take item from it!");
                list.wait();
            }
            Item consumed = list.removeFirst();
            System.out.println("The consumer now take an item " + consumed.getVal() + " from the list.");
            list.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        // producer thread
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    pc.produce(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "producer " + i).start();
        }

        // consumer thread
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "consumer").start();
        }

    }

}
