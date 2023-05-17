package graphs;

public class Graphs {

    public static void main(String[] args) {

        Graph graph = new Graph(5, true);
        Vertex vs  = graph.addVertex("s");
        Vertex vt = graph.addVertex("t");
        Vertex vy = graph.addVertex("y");
        Vertex vx = graph.addVertex("x");
        Vertex vz = graph.addVertex("z");
        graph.addEdge(vs, vt, -10);
        graph.addEdge(vs, vy, 5);
        graph.addEdge(vy, vz, 2);
        graph.addEdge(vy, vt, 3);
        graph.addEdge(vy, vx, 9);
        graph.addEdge(vt, vy, 2);
        graph.addEdge(vt, vx, 1);
        graph.addEdge(vx, vz, 4);
        graph.addEdge(vz, vs, 7);
        graph.addEdge(vz, vx, 6);

        Vertex arr[]=graph.dijkstra(vs);
        if (arr == null)
        {
            System.out.println("There is a negative weight in the graph!!!!!");
        }
        else
        {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println("Vertex = " + arr[i].toString() + " Its Parent :" + arr[i].getDijkParent());
    //              arr[i].displayList();
                }
        }
    }

}
