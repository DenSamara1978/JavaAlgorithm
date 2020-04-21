package Company;

import java.util.LinkedList;
import java.util.List;

public class Company {
    protected int id = -1;
    protected int parentId = -1;
    protected String name;

    private List<Integer> filails;

    protected float plan;
    protected float fact;

    private static int currentId = 0;

    public Company ( String name ) {
        this.name = name;
        this.id = currentId++;
        filails = new LinkedList();
    }

    public String getName () {
        return name;
    }

    public int getId () {
        return id;
    }

    public boolean addFilial ( int filial ) {
        if ( parentId != -1 )
            return false;

        filails.add ( filial );
        return true;
    }

    public boolean setParentId ( int parent ) {
        if ( !filails.isEmpty())
            return false;

        parentId = parent;
        return true;
    }

    public boolean isFilial () {
        return ( parentId != -1 );
    }

    public void setCountingValues ( float plan, float fact ) {
        this.plan = plan;
        this.fact = fact;
    }

    public String getStatistic () {
        return ( Math.abs(plan) < 1E-10 ) ? "had no planning" : "had executed " + String.valueOf(fact / plan * 100.0f) + "% of plan";
    }
}
