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
     

        String v[] = {"A","B","C","D","E","F","G","H","I","J"};
        double weight[] = {10,5,2,3,4,-2,0,7,2.5,-1.25};
        //double weight[] = {Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0,0,0,0,0};
        //double weight[] = {100,50,45.5,45.49,45.489,0,-0.01,-2,-9,-9.000001};
        Vertex vertices[] = new Vertex[10]; 
        int i;
        for(i = 0;i < v.length;i++)
        {
            vertices[i] = new Vertex(v[i]);
            vertices[i].setPQueueKey(weight[i]);
        }
        

        PriorityQueue q = new PriorityQueue(10);
        for(i = 0;i < v.length;i++)
        {
            q.insert(vertices[i]);
            System.out.println("-------------->");
            
        }
        PriorityQueueElement pqe =  q.pop();
        System.out.println(pqe.getPQueueKey());
        q.display();
        pqe = q.getMin();
        System.out.println(pqe.getPQueueKey());
        q.display();
        q.pop();
        System.out.println("----------------->");
        q.display();
        q.pop();
        System.out.println("----------------->");
        q.display();
        q.pop();
        System.out.println("----------------->");
        q.display();
        
        
        
    }
    
}
