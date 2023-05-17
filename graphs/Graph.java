package graphs;

import javax.swing.JOptionPane;

public class Graph {

    private Vertex vertices[];
    private int n;
    private int idx;
    private boolean directed;

    public Graph(int n, boolean directed) {
        this.vertices = new Vertex[n];
        this.n = n;
        idx = 0;
        this.directed = directed;
    }

    //check directed method.
    public Vertex addVertex(String data) {
        if (idx < n) {
            vertices[idx] = new Vertex(data);
            idx++;
        } else {
            JOptionPane.showMessageDialog(null, "Above Capacity of graph.");
        }
        return vertices[idx - 1];
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {

        if (v1.isConnected(v2)) {
            return;
        }

        if (directed == false) {
            v1.addEdge(v2, weight);
            v2.addEdge(v1, weight);
        } else {
            v1.addEdge(v2, weight);
        }

    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int getSize() {
        return idx;
    }
    
    
    

    public int mstPrimm(Vertex v) {
        
        int totalCost = 0;
        
        for (int i = 0; i < this.idx; i++) {
            this.vertices[i].setPQueueKey(Double.POSITIVE_INFINITY);
        }
        
        
        v.setPQueueKey(0);
        v.setMstParent(null);       
        
        PriorityQueue pqueue = new PriorityQueue(this.idx);
        
        
        for (int i = 0; i < this.idx; i++) {
            pqueue.insert(this.vertices[i]);
        }        
        
        while(!pqueue.isEmpty()){
            v = (Vertex) pqueue.pop();
            totalCost += v.getPQueueKey();
            
            for(Edge e : v.getAdjList()){
                if(e.v.isInPQueue() && e.weight < e.v.getPQueueKey()){
                    pqueue.decreaseKey(e.v, e.weight);
                    e.v.setMstParent(v);
                }
            }
        
        
        }               
        
        
        return totalCost;
    }


    public void initialization (Vertex v)
    {
        for (int i = 0; i<this.idx; i++)
        {
            this.vertices[i].setPQueueKey(Double.POSITIVE_INFINITY);
        }

        v.setPQueueKey(0);
    }


    public void relax (Vertex v1, Vertex v2, Double weight, PriorityQueue pq)
    {
        if (v2.getPQueueKey() > v1.getPQueueKey() + weight)
        {
            v2.setPQueueKey(v1.getPQueueKey() + weight);
            v2.setDijkstraParent(v1);
            pq.siftUp(v2.getPQueueIdx());
        }
    }



    public Vertex[] dijkstra (Vertex s)
    {
            initialization(s);
            s.setDijkstraParent(null);
            PriorityQueue pqueue = new PriorityQueue(this.idx);

            for(int i = 0; i < this.idx; i++)
            {
                pqueue.insert(this.vertices[i]);
            }

            Vertex [] result = new Vertex[this.idx];

            while (!pqueue.isEmpty())
            {
                Vertex v = (Vertex) pqueue.pop();
                for(Edge e : v.getAdjList())
                {
                    if (e.v.isInPQueue())
                    {
                        relax(v,e.v,e.weight,pqueue);
                    }
                }

            }

            return result;
    }
    
    
    

}
