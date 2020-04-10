import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Random random = new Random ();

        System.out.println("STACK");
        MyStack<Integer> stack = new MyStack ();
        System.out.println(stack);

        for (int i = 0; i < 6; i++) {
            int elm = random.nextInt(20);
            System.out.println("stack.push ( " + elm + " )");
            stack.push( elm );
            System.out.println(stack);
        }
        System.out.println();
        System.out.println("stack.peek() is :" + stack.peek());
        System.out.println();
        stack.recapacity(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(stack);
            System.out.println("stack.pop() is :" + stack.pop());
        }
        System.out.println(stack);
        System.out.println();

        System.out.println("QUEUE");
        MyQueue<Integer> queue = new MyQueue ();
        System.out.println(queue);

        for (int i = 0; i < 6; i++) {
            int elm = random.nextInt(20);
            System.out.println("queue.insert ( " + elm + " )");
            queue.insert ( elm );
            System.out.println(queue);
        }
        System.out.println();
        System.out.println("queue.peek() is :" + queue.peek());
        System.out.println();
        queue.recapacity(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(queue);
            System.out.println("queue.remove() is :" + queue.remove());
        }
        System.out.println(queue);
        System.out.println();

        System.out.println("PRIORITY_QUEUE");
        MyPriorityQueue<Integer> priorQueue = new MyPriorityQueue ();
        System.out.println(priorQueue);

        for (int i = 0; i < 6; i++) {
            int elm = random.nextInt(20);
            System.out.println("priorityQueue.insert ( " + elm + " )");
            priorQueue.insert ( elm );
            System.out.println(priorQueue);
        }
        System.out.println();
        System.out.println("priorityQueue.peek() is :" + priorQueue.peek());
        System.out.println();
        priorQueue.recapacity(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(priorQueue);
            System.out.println("priorityQueue.remove() is :" + priorQueue.remove());
        }
        System.out.println(priorQueue);
        System.out.println();

        System.out.println("DEQUEUE");
        MyDequeue<Integer> dequeue = new MyDequeue ();
        System.out.println(dequeue);
        System.out.println();

        System.out.println("dequeue.insertHead ( 1 )" );
        dequeue.insertHead ( 1 );
        System.out.println(dequeue);
        System.out.println();

        System.out.println("dequeue.insertHead ( 2 )" );
        dequeue.insertHead ( 2 );
        System.out.println(dequeue);
        System.out.println();

        System.out.println("dequeue.insertTail ( 3 )" );
        dequeue.insertTail ( 3 );
        System.out.println(dequeue);
        System.out.println();

        System.out.println("dequeue.insertTail ( 4 )" );
        dequeue.insertTail ( 4 );
        System.out.println(dequeue);
        System.out.println();

        dequeue.recapacity(20);

        for (int i = 0; i < 2; i++) {
            System.out.println("dequeue.removeHead() is :" + dequeue.removeHead());
            System.out.println(dequeue);
            System.out.println("dequeue.removeTail() is :" + dequeue.removeTail());
            System.out.println(dequeue);
        }
        System.out.println();

        MyStack<Character> symStack = new MyStack ( 100 );
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        for ( int i = 0; i < message.length();  ++i )
            symStack.push ( message.charAt ( i ));

        StringBuilder newMessage = new StringBuilder ();
        while ( !symStack.isEmpty ())
            newMessage.append ( symStack.pop ());

        System.out.println ( "Original message was: " + message );
        System.out.println ( "Reversed message is: " + newMessage );
    }
}
