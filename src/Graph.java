import java.util.LinkedList;

public class Graph {
    private final int vertexCount;
    private final LinkedList<Integer>[] adjList;

    private final int INFINITY = Integer.MAX_VALUE;

    public Graph(int vertexCount) {
        if (vertexCount <= 0)
            throw new IllegalArgumentException("Кол-во вершин " + vertexCount);

        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];

        for (int i = 0; i < vertexCount; ++i)
            adjList[i] = new LinkedList<>();
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>)adjList[vertex].clone();
    }

    public void addEdge(int v1, int v2) {
        if (( v1 < 0 ) || ( v2 < 0 ) || ( v1 >= vertexCount ) || ( v2 >= vertexCount ) || ( v1 == v2 ))
            throw new IllegalArgumentException( "Неверный узел графа");

        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    public LinkedList<Integer> path(int from, int to) {
        int [] edgeTo = new int[vertexCount];
        int [] distTo = new int[vertexCount];
        boolean [] marked = new boolean[vertexCount];

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = INFINITY;

        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(from);
        marked[from] = true;
        distTo[from] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w: getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }

        if (!marked[to])
            return null;

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = to;

        while (vertex != from) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }

        return stack;
    }


}
