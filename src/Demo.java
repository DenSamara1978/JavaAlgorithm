import java.util.Arrays;
import java.util.Random;

public class Demo {
    private final static int SIZE = 1_000_000;

    public static void main(String[] args) {
        MyArray arr = initArray();
        System.out.println( "Before sorting:");
        System.out.println( arr );
        System.out.println();

        MyArray arr1 = arr.getCopy();
        long start = System.currentTimeMillis();
        arr1.sortBubble ();
        long end = System.currentTimeMillis();
        System.out.println( "After bubble sorting:");
        System.out.println( arr1 );
        System.out.println( "Time is: " + (( end - start ) / 1000.0f ) + " seconds.");
        System.out.println();

        MyArray arr2 = arr.getCopy();
        start = System.currentTimeMillis();
        arr2.sortSelection ();
        end = System.currentTimeMillis();
        System.out.println( "After selection sorting:");
        System.out.println( arr2 );
        System.out.println( "Time is: " + (( end - start ) / 1000.0f ) + " seconds.");
        System.out.println();

        MyArray arr3 = arr.getCopy();
        start = System.currentTimeMillis();
        arr3.sortInsertion ();
        end = System.currentTimeMillis();
        System.out.println( "After insertion sorting:");
        System.out.println( arr3 );
        System.out.println( "Time is: " + (( end - start ) / 1000.0f ) + " seconds.");
        System.out.println();

        System.out.println ( "Are sorted arrayes equal: " + ( arr1.isEqual ( arr2 ) && arr1.isEqual ( arr3 )));
        System.out.println();

        Matrix matrix = new Matrix ( 5 );
        matrix.fillWithSpiral ();
        System.out.println ( "Matrix filled with a spiral is:\n" + matrix );
    }

    private static MyArray initArray ()
    {
        MyArray arr = new MyArray( SIZE);
        Random random = new Random();
        for ( int i = 0; i < SIZE; ++i )
            arr.setElement(i, random.nextInt( ));
        return arr;
    }
}
