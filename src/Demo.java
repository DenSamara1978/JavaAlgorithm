import java.util.Random;

public class Demo {
    static Random random = new Random ();

    public static void main(String[] args) {

//      testLesson03 ();
        testLesson04();
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

    public static void testLesson03 ()
    {
        testMyStack();
        System.out.println();

        testMyQueue();
        System.out.println();

        testMyPriorityQueue();
        System.out.println();

        testMyDequeue();
        System.out.println();

        testReversingString();
    }

    private static void testReversingString() {
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

    private static void testMyDequeue() {
        System.out.println("DEQUEUE");
        MyDequeue<Integer> dequeue = new MyDequeue ();
        System.out.println(dequeue);

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
    }

    private static void testMyPriorityQueue() {
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
    }

    private static void testMyQueue() {

      
      
      
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
    }

    private static void testMyStack() {
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
    }

    public static void testLesson04 ()
    {
        testMyList();
        System.out.println();
        testMyForwardList();
        System.out.println();
        testMyExtStack();
        System.out.println();
        testMyExtQueue();
        System.out.println();
        testMyExtDequeue();
    }

    private static void testMyExtQueue() {
        MyExtQueue<Integer> queue = new MyExtQueue<Integer> ();
        System.out.println(queue);
        queue.insert(1);
        System.out.println("insert(1)");
        System.out.println(queue);
        queue.insert(2);
        System.out.println("insert(2)");
        System.out.println(queue);
        queue.insert(3);
        System.out.println("insert(3)");
        System.out.println(queue);
        System.out.println("get(): " + queue.get());
        System.out.println(queue);
        System.out.println("remove(): " + queue.remove());
        System.out.println(queue);
        System.out.println("remove(): " + queue.remove());
        System.out.println(queue);
        System.out.println("remove(): " + queue.remove());
        System.out.println(queue);
    }

    private static void testMyExtStack() {
        MyExtStack<Integer> stack = new MyExtStack<Integer>();
        System.out.println(stack);
        stack.push(1);
        System.out.println("push(1)");
        System.out.println(stack);
        stack.push(2);
        System.out.println("push(2)");
        System.out.println(stack);
        stack.push(3);
        System.out.println("push(3)");
        System.out.println(stack);
        System.out.println("peek(): " + stack.peek ());
        System.out.println(stack);
        System.out.println("pop(): " + stack.pop());
        System.out.println(stack);
        System.out.println("pop(): " + stack.pop());
        System.out.println(stack);
        System.out.println("pop(): " + stack.pop());
        System.out.println(stack);
    }

    private static void testMyForwardList() {
        MyForwardList<Integer> flist = new MyForwardList<Integer> ();
        System.out.println(flist);
        flist.insert(1);
        System.out.println("insert(1)");
        System.out.println(flist);
        flist.insert(2);
        System.out.println("insert(2)");
        System.out.println(flist);
        flist.insert(3);
        System.out.println("insert(3)");
        System.out.println(flist);
        System.out.println("remove(): " + flist.remove());
        System.out.println(flist);
        System.out.println("remove(): " + flist.remove());
        System.out.println(flist);
        System.out.println("remove(): " + flist.remove());
        System.out.println(flist);
    }

    private static void testMyList() {
        MyList<Integer> list = new MyList<Integer> ();
        System.out.println(list);
        list.insertHead(2);
        System.out.println("insertHead(2)");
        System.out.println(list);
        list.insertHead(3);
        System.out.println("insertHead(3)");
        System.out.println(list);
        list.insertTail(4);
        System.out.println("insertTail(4)");
        System.out.println(list);
        list.insert(5,1);
        System.out.println("insert(5,1)");
        System.out.println(list);
        System.out.println("remove(2): " + list.remove(2));
        System.out.println(list);
        System.out.println("removeHead(): " + list.removeHead());
        System.out.println(list);
        System.out.println("removeTail(): " + list.removeTail());
        System.out.println(list);
    }

    private static void testMyExtDequeue() {
        System.out.println("DEQUEUE");
        MyExtDequeue<Integer> dequeue = new MyExtDequeue ();
        System.out.println(dequeue);
        System.out.println("insertHead ( 1 )" );
        dequeue.insertHead ( 1 );
        System.out.println(dequeue);
        System.out.println("insertHead ( 2 )" );
        dequeue.insertHead ( 2 );
        System.out.println(dequeue);
        System.out.println("insertTail ( 3 )" );
        dequeue.insertTail ( 3 );
        System.out.println(dequeue);
        System.out.println("insertTail ( 4 )" );
        dequeue.insertTail ( 4 );
        System.out.println(dequeue);
        for (int i = 0; i < 2; i++) {
            System.out.println("removeHead() is :" + dequeue.removeHead());
            System.out.println(dequeue);
            System.out.println("removeTail() is :" + dequeue.removeTail());
            System.out.println(dequeue);
        }
    }
}
