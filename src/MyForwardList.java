public class MyForwardList<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public MyForwardList () {
        head = tail = null;
        size = 0;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return ( size == 0 );
    }

    public void insert ( Item item ) {
        Node<Item> newNode = new Node<>( item );

        if ( isEmpty ())
            head = tail = newNode;
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        ++size;
    }

    public Item get () {
        return ( head == null ) ? null : head.getValue();
    }

    public Item remove () {
        if ( isEmpty())
            return null;
        else {
            Node<Item> node = head;
            head = node.getNext();
            node.setNext(null);
            --size;
            return node.getValue();
        }
    }
    public String toString ()
    {
        StringBuilder buffer = new StringBuilder ();
        buffer.append( "ForwardList: { ");
        Node<Item> node = head;
        while ( node != null ) {
            buffer.append(node.getValue());
            if (( node = node.getNext()) != null )
                buffer.append(", ");
        }
        buffer.append ( " }" );
        return buffer.toString();
    }

    class Node<Item> {
        private Node<Item> next;
        private Item value;

        public Node ( Item item ) {
            next = null;
            value = item;
        }

        public Node<Item> getNext () {
            return next;
        }

        public void setNext ( Node<Item> node ) {
            next = node;
        }

        public Item getValue () {
            return value;
        }

        public void setValue ( Item item ) {
            value = item;
        }
    }
}
