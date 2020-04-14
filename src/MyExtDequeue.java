public class MyExtDequeue<Item> {
    private MyList<Item> list;

    public MyExtDequeue() {
        list = new MyList<Item> ();
    }

    public int size () {
        return list.size();
    }

    public void insertHead ( Item elm ) {
        list.insertHead ( elm );
    }

    public void insertTail ( Item elm ) {
        list.insertTail ( elm );
    }

    public Item peekHead () {
        return list.getHead();
    }

    public Item peekTail () {
        return list.getTail();
    }

    public Item removeHead () {
        return list.removeHead();
    }

    public Item removeTail () {
        return list.removeTail();
    }

    public boolean isEmpty ()
    {
        return list.isEmpty();
    }

    public String toString ()
    {
        return "DEQUEUE:" + list;
    }
}
