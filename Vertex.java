package graphs;

import java.util.LinkedList;

public class Vertex implements PriorityQueueElement {

    private String data;
    private boolean inPQueue;
    private int pQueueKey;
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
    public int getPQueueKey() {
        return pQueueKey;
    }

    @Override
    public void setPQueueKey(int pQueueKey) {
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

}
