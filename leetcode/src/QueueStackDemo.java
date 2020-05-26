import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueStackDemo {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        System.out.println(deque);
        System.out.println("======================");
        String s = deque.peek();
        System.out.println(s);
        System.out.println(deque);
        System.out.println("======================");

        while (deque.size() > 0) {
            System.out.println(deque.poll());
        }
        System.out.println(deque);

        System.out.println(6 >> 1);
    }
}
