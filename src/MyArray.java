import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private int [] arr;
    private int length;

    public MyArray ( int _length )
    {
        length = _length;
        arr = new int [length];
    }

    public int getLength ()
    {
        return length;
    }

    public MyArray getCopy ()
    {
        MyArray copy = new MyArray ( arr.length );
        copy.arr = Arrays.copyOfRange( arr, 0, length );
        copy.length = length;
        return copy;
    }

    public boolean isEqual ( MyArray arr1 )
    {
        if ( arr.length != arr1.length )
            return false;
        for ( int i = 0; i < length; ++i )
        {
            if ( arr [i] != arr1.arr [i] )
                return false;
        }
        return true;
    }

    public int getElement ( int index )
    {
        if (( index < 0 ) || ( index > length - 1 )) throw new ArrayIndexOutOfBoundsException();
        return arr [index];
    }

    public void setElement ( int index, int value )
    {
        if (( index < 0 ) || ( index > length - 1 )) throw new ArrayIndexOutOfBoundsException();
        arr[index] = value;
    }

    public void appendElement ( int value )
    {
        if ( length >= arr.length ) throw new ArrayStoreException();
        arr [length++] = value;
    }

    public int search ( int value )
    {
        for ( int i = 0; i < length; ++i )
        {
            if ( arr [i] == value)
                return i;
        }
        return -1;
    }

    public void deleteElement ( int index )
    {
        if (( index < 0 ) || ( index > length - 1 )) throw new ArrayIndexOutOfBoundsException();
        if (length - 1 - index >= 0) System.arraycopy(arr, index + 1, arr, index, length - 1 - index);
        --length;
    }

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        int len = length;
        if ( length > 100 ) {
            result.append( "Only first 100 elements: " );
            len = 100;
        }
        if ( len > 0 )
        {
            result.append("[");
            for ( int i = 0; i < len; ++i )
            {
                result.append(arr[i]);
                if ( i != length - 1 )
                    result.append(", ");
            }
            if ( len != length )
                result.append("...");
            result.append("]");
        }
        return result.toString();
    }

    private void exchangeElements ( int index1, int index2 )
    {
        int temp = arr [index1];
        arr [index1] = arr [index2];
        arr [index2] = temp;
    }

    public void sortBubble ()
    {
        if ( length < 2 ) return;
        for ( int max = length - 1; max > 0; --max ) {
            for ( int i = 0; i < max; ++i )
            {
                if ( arr [i] > arr [i + 1] )
                    exchangeElements(i, i + 1);
            }
        }
    }

    public void sortSelection ()
    {
        if ( length < 2 ) return;
        int marker, value;
        for ( int i = 0; i < length - 1; ++i ) {
            value = arr [i];
            marker = i;
            for (int j = i + 1; j < length; ++j) {
                if ( arr [j] < value ) {
                    value = arr [j];
                    marker = j;
                }
            }
            if ( marker != i )
                exchangeElements( i, marker);
        }
    }

    public void sortInsertion ()
    {
        if ( length < 2 ) return;
        for ( int i = 1; i < length; ++i ) {
            int temp = arr [i];
            for ( int j = i - 1; j >=0; --j )
            {
                if ( arr [j] > temp )
                    arr [j + 1] = arr [j];
                else {
                    if ( j != i - 1 )
                        arr [j + 1] = temp;
                    break;
                }

                if ( j == 0 )
                    arr [0] = temp;
            }
        }
    }
}
