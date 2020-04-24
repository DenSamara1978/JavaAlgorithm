import Company.CompanyPool;
import Company.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.Random;

public class Demo {
    static Random random = new Random ();

    public static void main(String[] args)
    {
        testLesson08();
    }

    public static void testLesson08 () {
        ChainingHashMap<String,String> map = new ChainingHashMap<>();
        map.put ( "One", "Один" );
        map.put ( "Two", "Два" );
        map.put ( "Three", "Три" );
        map.put ( "Four", "Четыре" );
        map.put ( "Five", "Пять" );
        map.put ( "Six", "Шесть" );
        map.put ( "Seven", "Семь" );
        map.put ( "Eight", "Восемь" );
        map.put ( "Nine", "Девять" );
        map.put ( "Ten", "Десять" );
        map.put ( "Eleven", "Одиннадцать" );
        map.put ( "Twelve", "Двенадцать" );
        map.put ( "Thirteen", "Тринадцать" );
        map.put ( "Fourteen", "Четырнадцать" );
        map.put ( "Fifteen", "Пятнадцать" );
        map.put ( "Sixteen", "Шестнадцать" );
        map.put ( "Seventeen", "Семнадцать" );
        map.put ( "Eighteen", "Восемнадцать" );
        map.put ( "Nineteen", "Девятнадцать" );
        map.put ( "Twenty", "Двадцать" );

        System.out.println(map);

        System.out.println("\nУдаление элемента с ключом \"Seven\": " + map.remove("Seven"));
        System.out.println();
        System.out.println(map);

        System.out.println("\nУдаление элемента с ключом \"Hundred\": " + map.remove("Hundred"));
        System.out.println();
        System.out.println(map);
    }

    public static void testLesson07 () {
        testGraph();
        testCompany();
    }

    public static void testGraph () {
        Graph graph = new Graph(10);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,9);
        graph.addEdge(2,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(3,7);
        graph.addEdge(7,8);
        graph.addEdge(8,9);

        System.out.println(graph.path(1,6));
    }

    public static void testCompany () {
        ExcelReader reader = new ExcelReader("CompanyIndicators.xlsx");
        CompanyPool pool = null;
        try {
            pool = reader.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(pool.getStatisticOfCompanies());
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
