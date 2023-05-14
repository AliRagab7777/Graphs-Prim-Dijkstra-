package graphs;

import java.util.LinkedList;

public class Vertex implements PriorityQueueElement {

    private String data;
    private boolean inPQueue;
    private double pQueueKey;
    private int pQueueIdx;
    private LinkedList<Edge> adjList;

    public Vertex(String data) {
        this.data = data;        
        this.pQueueIdx = -1;
        this.adjList = new LinkedList<>();
    }

    public void addEdge(Edge e) {
        this.adjList.add(e);
    }

    public void addEdge(Vertex v, int weight) {
        this.adjList.add(new Edge(v, weight));
    }

    @Override
    public double getPQueueKey() {
        return pQueueKey;
    }

    @Override
    public void setPQueueKey(double pQueueKey) {
        this.pQueueKey = pQueueKey;
    }

    @Override
    public int getPQueueIdx() {
        return pQueueIdx;
    }

    @Override
    public void setPQueueIdx(int pQueueIdx) {
        this.pQueueIdx = pQueueIdx;
    }

    @Override
    public boolean isInPQueue() {
        return inPQueue;
    }

    @Override
    public void removeFromPQueue() {
        inPQueue = false;
    }

    @Override
    public void addToPQueue() {
        inPQueue = true;
    }
    
    public boolean isConnected(Vertex v2)
    {
        int i;
        for(i = 0;i < this.adjList.size();i++)
        {
            if(this.adjList.get(i).v == v2) 
                return true;
        }
        return false;
    }
    
    public void displayList()
    {
        System.out.println("The neighbours of vertex " + this.data + " is(are): ");
        int i;
        for(i = 0;i < this.adjList.size();i++){
            System.out.println(this.adjList.get(i).v.data + "," + this.adjList.get(i).weight);
        }
        if(adjList.size() == 0)
            System.out.println("No neighbours found.");
    }

    public void display()
    {
        System.out.println(data);
    }
    
}
