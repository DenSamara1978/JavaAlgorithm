public class MyQueue<Item> {
    private Item[] list; // меньший индекс-хвост, больший индекс-голова
    private int head = 0;
    private int tail = 0;
    private final static int DEFAULT_CAPACITY = 10;

    MyQueue () {
        this ( DEFAULT_CAPACITY );
    }

    MyQueue (int initialCapacity )
    {
        if ( initialCapacity <= 0 ) throw new IllegalArgumentException ( "Bad queue size" );
        list = (Item[]) new Object [initialCapacity];
        tail = head = initialCapacity - 1;
    }

    public void recapacity ( int newCapacity )
    {
        if ( newCapacity < size ()) throw new IllegalArgumentException ( "Bad queue size" );
        Item[] newList = (Item[]) new Object [newCapacity];
        int index = head;
        int count = size ();

        head = newCapacity - 1;
        tail = head - count;

        int newIndex = newCapacity - 1;
        for (int i = 0; i < count; i++) {
            newList[newIndex] = list[index];
            index = nextIndex(index);
            newIndex = nextIndex(newIndex);
        }
        list = newList;
    }

    private int nextIndex ( int index )
    {
        return ( index == 0 ) ? list.length - 1 : index - 1;
    }

    private int prevIndex ( int index )
    {
        return ( index == list.length - 1 ) ? 0 : index + 1;
    }

    public int size ()
    {
        int size = head - tail;
        if ( size < 0 )
            size += list.length;
        return size;
    }

    public void insert ( Item elm )
    {
        if ( isFull ()) throw new StackOverflowError ( "MyQueue is full" );
        list [tail] = elm;
        tail = nextIndex ( tail );
    }

    public Item peek ()
    {
        if ( isEmpty ()) throw new StackOverflowError ( "MyQueue is empty" );
        return  list [head];
    }

    public Item remove ()
    {
        Item elm = peek ();
        list [head] = null;
        head = nextIndex ( head );
        return  elm;
    }

    public boolean isEmpty ()
    {
        return ( size() == 0 );
    }

    public boolean isFull ()
    {
        return ( size () == list.length );
    }

    public String toString ()
    {
        StringBuilder buffer = new StringBuilder ();
        buffer.append( "Queue: <- { ");
        int length = size ();
        int index = head;
        while ( index != tail ) {
            buffer.append ( list [index] );
            index = nextIndex ( index );
            if ( index != tail )
                buffer.append ( ", " );
        }
        buffer.append ( " } <-" );
        return buffer.toString();
    }
}
