public class MyStack<Item> {
    private Item[] list; // 0 - вершина стека, рост стека в направлении увеличения индексов ( не так, как в x86-64 )
    private int top = 0; // Указывает на позицию в стеке с вершины, в которую ближайшая команада PUSH сохранить значение ( аналог RSP/ESP/SP в x86-64 )
    private final static int DEFAULT_CAPACITY = 10;

    MyStack () {
        this ( DEFAULT_CAPACITY );
    }

    MyStack (int initialCapacity )
    {
        if ( initialCapacity <= 0 ) throw new IllegalArgumentException ( "Bad stack size" );
        list = (Item[]) new Object [initialCapacity];
    }

    public void recapacity ( int newCapacity )
    {
        if ( newCapacity < top ) throw new IllegalArgumentException ( "Bad stack size" );
        Item[] newList = (Item[]) new Object [newCapacity];
        for (int i = 0; i < top; i++)
            newList [i] = list [i];
        list = newList;
    }

    public void push ( Item elm )
    {
        if ( isFull ()) throw new StackOverflowError ( "MyStack is full" );
        list [top++] = elm;
    }

    public Item peek ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyStack is empty" );
        return  list [top - 1];
    }

    public Item pop ()
    {
        Item elm = peek ();
        list [--top] = null;
        return  elm;
    }

    public boolean isEmpty ()
    {
        return ( top <= 0 );
    }

    public boolean isFull ()
    {
        return ( top >= list.length );
    }

    public String toString ()
    {
        StringBuilder buffer = new StringBuilder ();
        buffer.append( "Stack: { ");
        for (int i = 0; i < top; i++) {
            buffer.append ( list [i] );
            if ( i < top - 1 )
                buffer.append ( ", " );
        }
        buffer.append ( " } <- top" );
        return buffer.toString();
    }
}
