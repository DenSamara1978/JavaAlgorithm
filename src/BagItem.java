public class BagItem {
    private String name;
    private int weight;
    private int cost;

    public BagItem ( String name, int weight, int cost ) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName () { return name; }

    public int getWeight () { return weight; }

    public int getCost () { return cost; }
}
