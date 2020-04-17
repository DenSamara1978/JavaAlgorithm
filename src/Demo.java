import java.util.Random;

public class Demo {
    static Random random = new Random ();

    public static void main(String[] args)
    {
        testLesson06();
    }

    private static final int TREE_DEPTH = 6;
    private static final int TREE_COUNT = 20;

    public static void testLesson06 () {
        MyTreeMap<Integer, Integer> [] maps = new MyTreeMap[20];
        for (int i = 0; i < TREE_COUNT; i++) {
            maps[i] = new MyTreeMap<>();
            while ( maps[i].maxDepth() < TREE_DEPTH ) {
                int val = random.nextInt( 200 ) - 100;
                maps [i].put( val, val );
            }
        }

        int[] disbalances = new int [TREE_DEPTH];
        for (int i = 0; i < TREE_COUNT; i++) {
            int disbalance = maps[i].getDisbalance();
            disbalances[disbalance] ++;
            System.out.println("Дерево " + i + " имеет максимальную и минимальную глубины "+ maps[i].maxDepth() + ", " + maps[i].minDepth() + ", дисбаланс " + maps[i].getDisbalance());
        }

        System.out.println();

        System.out.println("Распределение дисбалансов");
        for (int i = 0; i < TREE_DEPTH; i++) {
            System.out.println("Дисбаланс " + i + " наблюдается у " + disbalances [i] + " ( " + ( disbalances [i] * 100 / TREE_COUNT )  + "% ) деревеьев");
        }
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
