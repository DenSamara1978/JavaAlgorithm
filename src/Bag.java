public class Bag {
    private MyList<BagItem> pool;
    private int maxWeight;
    private int bestCost;

    private MyList<BagItem> set;

    public Bag ( int maxWeight ) {
        this.pool = new MyList<>();
        this.maxWeight = maxWeight;
        this.set = new MyList<>();
    }

    public void addItemIntoPool ( BagItem item ) {
        pool.insertHead(item);
    }

    public void resolveSet () {
        bestCost = 0;
        fumbleSets ( pool );
    }

    private int calculateCost ( MyList<BagItem> list ) {
        int result = 0;
        for ( int i = 0; i < list.size (); ++i )
            result += list.get ( i ).getCost();
        return result;
    }

    private int calculateWeight ( MyList<BagItem> list ) {
        int result = 0;
        for ( int i = 0; i < list.size (); ++i )
            result += list.get ( i ).getWeight();
        return result;
    }

    public void fumbleSets(MyList<BagItem> list )
    {
        int weight = calculateWeight ( list );
        int cost = calculateCost ( list );
        if (( weight <= maxWeight ) && ( cost > bestCost )) {
            set = new MyList<>( list );
            bestCost = cost;
        }

        if ( list.size() <= 1 )
            return;

        for (int index = 0; index < list.size(); ++index) {
            MyList<BagItem> newSet = new MyList<>(list);
            newSet.remove(index);
            fumbleSets(newSet);
        }

    }
    public String toString () {
        if ( set.size() == 0 ) return "Bag is empty";
        for ( int index = 0; index < set.size(); ++index) {
            BagItem item = set.get(index);
            System.out.println(item.getName() + " весом " + item.getWeight() +" ценой " + item.getCost());
        }
        return "";
    }
}
