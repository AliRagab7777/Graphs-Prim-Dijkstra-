package graphs;

public class Graphs {

    public static void main(String[] args) {
        
        
//        Graph g = new Graph(5,false);
//        Vertex v1 = g.addVertex("A");
//        Vertex v2 = g.addVertex("B");
//        Vertex v3 = g.addVertex("C");
//        Vertex v4 = g.addVertex("D");
//        g.addEdge(v1,v2,10);
//        g.addEdge(v1, v3, 5);
////        System.out.println(v1.isConnected(v3));
////        System.out.println(v3.isConnected(v1));
////        System.out.println(v3.isConnected(v4));
//        g.addEdge(v3, v1, 8);
//        v1.displayList();
//        v2.displayList();
//        v3.displayList();
        
        
        Vertex v11 = new Vertex("A");
        v11.setPQueueKey(10);
        Vertex v12 = new Vertex("B");
        v12.setPQueueKey(2);
        Vertex v13 = new Vertex("C");
        v13.setPQueueKey(1);
        
        PriorityQueue q = new PriorityQueue(5);
        q.insert(v11);
        System.out.println("------->");
        q.insert(v12);
        System.out.println("------->");
        q.insert(v13);
        //q.display();
        
    }
    
}
