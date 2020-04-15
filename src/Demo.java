import java.util.Random;

public class Demo {
    static Random random = new Random ();

    public static void main(String[] args) {
        testLesson05();
    }

    public static void testLesson05 () {
        testPow ();
        System.out.println();
        testBinarySearching ();
        System.out.println();
        testBag();
    }

    public static void testPow () {
        System.out.println("pow(2, 3) is " + MyMath.pow(2,3));
        System.out.println("pow(3, 1) is " + MyMath.pow(3,1));
        System.out.println("pow(4, 0) is " + MyMath.pow(4,0));
        System.out.println("pow(16, 4) is " + MyMath.pow(16,4));
    }

    public static void testBinarySearching () {
        MyArr arr = new MyArr(10);
        arr.insert(-10);
        arr.insert(45);
        arr.insert(26);
        arr.insert(20);
        arr.insert(25);
        arr.insert(40);
        arr.insert(75);
        arr.insert(80);
        arr.insert(82);
        arr.insert(91);
        int search = 26;
        System.out.println(arr.binaryFind(search));
    }

    public static void testBag () {
        Bag bag = new Bag ( 300 );
        bag.addItemIntoPool(new BagItem( "Item1",100, 40));
        bag.addItemIntoPool(new BagItem("Item2",200, 10));
        bag.addItemIntoPool(new BagItem("Item3",50, 200));
        bag.addItemIntoPool(new BagItem("Item4",150, 150));
        bag.addItemIntoPool(new BagItem("Item5",300, 30));
        bag.resolveSet();
        System.out.println(bag);
    }
}
