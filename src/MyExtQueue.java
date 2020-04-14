public class MyExtQueue<Item> {
    private MyForwardList<Item> list;

    public MyExtQueue() {
        list = new MyForwardList<Item> ();
    }

    public void insert ( Item elm )
    {
        list.insert(elm);
    }

    public Item get ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyQueue is empty" );
        return list.get();
    }

    public Item remove ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyQueue is empty" );
        return list.remove();
    }

    public boolean isEmpty ()
    {
        return list.isEmpty();
    }

    public String toString ()
    {
        return "QUEUE:" + list;
    }
}
