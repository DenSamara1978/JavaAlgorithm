public class MyList<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public MyList () {
        head = tail = null;
        size = 0;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return ( size == 0 );
    }

    public void insertHead ( Item item ) {
        Node<Item> newNode = new Node<> ( item );
        if ( isEmpty ())
            head = tail = newNode;
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        ++size;
    }

    public void insertTail ( Item item ) {
        Node<Item> newNode = new Node<> ( item );
        if ( isEmpty ())
            head = tail = newNode;
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        ++size;
    }

    public void insert ( Item item, int index ) {
        Node<Item> newNode = new Node<> ( item );
        if ( index <= 0 )
            insertHead( item );
        else if ( index > size )
            insertTail(item);
        else {
            ++size;
            Node<Item> node = searchNode ( index );
            node.getPrev().setNext( newNode );
            newNode.setPrev( node.getPrev ());
            node.setPrev( newNode );
            newNode.setNext( node );
        }
    }

    private Node<Item> searchNode ( int index ) {
        Node<Item> curNode = head;
        int curIndex = 0;
        while (( curIndex < index ) || ( curNode != null )) {
            if (( curIndex++ ) == index )
                break;
            curNode = curNode.getNext();
        }
        return curNode;
    }

    private Node<Item> searchNode ( Item item ) {
        Node<Item> curNode = head;
        while ( curNode != null ) {
            if ( curNode.getValue().equals ( item ))
                break;
            curNode = curNode.getNext();
        }
        return curNode;
    }

    public Item getHead() {
        return ( head == null ) ? null : head.getValue();
    }

    public Item getTail() {
        return ( tail == null ) ? null : tail.getValue();
    }

    public Item removeHead () {
        if ( isEmpty())
            return null;
        else {
            Node<Item> node = head;
            if ( head.getNext() != null )
                head.getNext().setPrev(null);
            else
                tail = null;
            head = head.getNext();
            node.setNext(null);
            node.setPrev(null);
            --size;
            return node.getValue();
        }
    }

    public Item removeTail () {
        if ( isEmpty())
            return null;
        else {
            Node<Item> node = tail;
            if ( tail.getPrev() != null )
                tail.getPrev().setNext(null);
            else
                head = null;
            tail = node.getPrev();
            node.setNext(null);
            node.setPrev(null);
            --size;
            return node.getValue();
        }
    }

    public Item remove ( Item item ) {
        Node<Item> node = searchNode ( item );
        if ( node == null )
            return null;
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(null);
        node.setPrev(null);
        --size;
        return node.getValue();
    }

    public Item remove ( int index ) {
        if ( index <= 0 )
            return removeHead();
        else if ( index > size - 1 )
            return removeTail();
        else {
            --size;
            Node<Item> node = searchNode ( index );
            node.getNext().setPrev(node.getPrev());
            node.getPrev().setNext(node.getNext());
            node.setNext(null);
            node.setPrev(null);
            return node.getValue();
        }
    }

    public Item get ( int index ) {
        Node<Item> node = searchNode( index );
        return ( node == null ) ? null : node.getValue();
    }

    public String toString ()
    {
        StringBuilder buffer = new StringBuilder ();
        buffer.append( "List: { ");
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
        private Node<Item> prev;
        private Item value;

        public Node ( Item item ) {
            next = prev = null;
            value = item;
        }

        public Node<Item> getNext () {
            return next;
        }

        public Node<Item> getPrev () {
            return prev;
        }

        public void setNext ( Node<Item> node ) {
            next = node;
        }

        public void setPrev ( Node<Item> node ) {
            prev = node;
        }

        public Item getValue () {
            return value;
        }

        public void setValue ( Item item ) {
            value = item;
        }
    }
}
