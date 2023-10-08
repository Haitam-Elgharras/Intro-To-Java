import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

    public static void show() {
        // Queue not arrayDequeue
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        // c->a->b
        var front = queue.peek();// c (returns null if empty)
        var front2 = queue.element();// c (throws exception if empty)
        front = queue.remove();// c (throws exception if empty)
        front = queue.poll();// a (returns null if empty)

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        // c->b->a in the inverse order

        ArrayDeque<String> queueBasedOnArrayDeque = new ArrayDeque<>();
        queueBasedOnArrayDeque.add(stack.pop());// c
        queueBasedOnArrayDeque.add(stack.pop());// b
        queueBasedOnArrayDeque.add(stack.pop());// a
        // c->b->a in the original order of insertion

        // the arrayDeque give us the possibility to pop elements from the end or the beginning :
        // stack.pop() -> pop from the end
        // queueBasedOnArrayDeque.remove() -> pop from the beginning




    }
}
