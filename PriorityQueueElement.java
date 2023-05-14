package graphs;

public interface PriorityQueueElement {

    double getPQueueKey();

    void setPQueueKey(double key);

    int getPQueueIdx();

    void setPQueueIdx(int idx);

    boolean isInPQueue();

    void removeFromPQueue();

    void addToPQueue();

    void display();
}
