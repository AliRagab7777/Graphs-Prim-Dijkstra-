package graphs;

public interface PriorityQueueElement {

    int getPQueueKey();

    void setPQueueKey(int key);

    int getPQueueIdx();

    void setPQueueIdx(int idx);

    boolean isInPQueue();

    void removeFromPQueue();

    void addToPQueue();

}
