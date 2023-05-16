package graphs;

public class Graphs {

    public static void main(String[] args) {

        Graph graph = new Graph(9, false);
        Vertex va  = graph.addVertex("a");
        Vertex vb = graph.addVertex("b");
        Vertex vc = graph.addVertex("c");
        Vertex vd = graph.addVertex("d");
        Vertex ve = graph.addVertex("e");
        Vertex vf = graph.addVertex("f");
        Vertex vg = graph.addVertex("g");
        Vertex vh = graph.addVertex("h");
        Vertex vi = graph.addVertex("i");
        
        
        graph.addEdge(va, vh, 8);
        graph.addEdge(va, vb, 4);
        
        
        graph.addEdge(vb, vh, 11);
        graph.addEdge(vb, vc, 8);
        
        graph.addEdge(vh, vi, 7);
        graph.addEdge(vh, vg, 1);
        
        graph.addEdge(vi, vc, 2);
        graph.addEdge(vi, vg, 6);
        
        
        graph.addEdge(vc, vd, 7);
        graph.addEdge(vc, vf, 4);
        
        
        graph.addEdge(vg, vf, 2);
        
        graph.addEdge(vd, ve, 9);
        graph.addEdge(vd, vf, 14);
        
        graph.addEdge(ve, vf, 10);
        
        
        int totalCost = graph.mstPrimm(va);
        
        
        for(int i=0; i<graph.getSize(); i++){
            System.out.println(graph.getVertices()[i] + " ----> (" + graph.getVertices()[i].getPQueueKey() + ") ---->" + graph.getVertices()[i].getMstParent());
            
        
        }
        
        System.out.println("Total Cost " + totalCost);
        
    }

}
