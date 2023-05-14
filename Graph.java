package graphs;

import javax.swing.JOptionPane;

public class Graph {
    
    private Vertex vertices[];
    private int n;
    private int i;
    private boolean directed;
    
    public Graph(int n,boolean directed) {
        this.vertices = new Vertex[n];
        this.n = n;
        i = 0;
        this.directed = directed;
    }
    
    
    //check directed method.
    
    public Vertex addVertex(String data) {
        if (i < n) {
            vertices[i] = new Vertex(data);
            i++;
        } else {
            JOptionPane.showMessageDialog(null, "Above Capacity of graph.");
        }    
        return vertices[i-1];
    }
    
    public void addEdge(Vertex v1, Vertex v2, int weight) {
        
        if(v1.isConnected(v2))
            return;
        
        if (directed == false) {
            v1.addEdge(v2, weight);
            v2.addEdge(v1, weight);
        } else {
            v1.addEdge(v2, weight);
        }
        
    }
    
}
