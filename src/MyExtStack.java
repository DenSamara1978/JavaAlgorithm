public class MyExtStack<Item> {
    private MyList<Item> list;

    public MyExtStack() {
        list = new MyList<Item> ();
    }

    public void push ( Item elm )
    {
        list.insertHead(elm);
    }

    public Item peek ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyExtStack is empty" );
        return list.getHead();
    }

    public Item pop ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyExtStack is empty" );
        return list.removeHead();
    }

    public boolean isEmpty ()
    {
        return list.isEmpty();
    }

    public String toString ()
    {
        return "STACK:" + list;
    }
}
