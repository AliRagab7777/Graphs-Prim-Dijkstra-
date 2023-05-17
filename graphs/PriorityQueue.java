package graphs;

public class PriorityQueue {

    private PriorityQueueElement arr[];
    private int size;
    private int idx;

    public PriorityQueue(int size) {
        this.size = size;
        this.arr = new PriorityQueueElement[size];
        this.idx = 0;
    }

    private boolean validIdx(int i) {
        return i >= 0 && i < this.idx;
    }

    private void swap(int x, int y) {
        if (validIdx(x) && validIdx(y)) {
            PriorityQueueElement temp = this.arr[x];
            this.arr[x] = this.arr[y];
            this.arr[y] = temp;
            this.arr[x].setPQueueIdx(x);
            this.arr[y].setPQueueIdx(y);

        }

    }

    public void siftUp(int index) {
        int parentIdx = (index - 1) / 2;
        if (!validIdx(parentIdx)) {
            return;
        }
        if (arr[parentIdx].getPQueueKey() <= arr[index].getPQueueKey()) {
            return;
        }
        swap(index, parentIdx);
        siftUp(parentIdx);

    }

    public void insert(PriorityQueueElement pqe) {
        if (this.idx >= this.size) {
            return;
        }

        this.arr[this.idx] = pqe;
        pqe.addToPQueue();
        pqe.setPQueueIdx(this.idx);
        this.idx += 1;
        siftUp(this.idx - 1);       

    }

    private void heapify(int i) {
        if (!validIdx(i)) {
            return;
        }

        int minIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (validIdx(left) && arr[minIdx].getPQueueKey() > arr[left].getPQueueKey()) {
            minIdx = left;
        }

        if (validIdx(right) && arr[minIdx].getPQueueKey() > arr[right].getPQueueKey()) {
            minIdx = right;
        }

        if (minIdx == i) {
            return;
        }

        swap(i, minIdx);
        heapify(minIdx);
    }

    public PriorityQueueElement pop() {
        if (this.idx == 0) {
            return null;
        }

        swap(0, this.idx - 1);
        this.idx--;
        heapify(0);
        this.arr[this.idx].removeFromPQueue();
        return this.arr[this.idx];
    }

    public void decreaseKey(PriorityQueueElement pqe, Double newKey) {
        if (pqe.isInPQueue() && newKey < pqe.getPQueueKey()) {
            if (validIdx(pqe.getPQueueIdx())) {

                pqe.setPQueueKey(newKey);
                siftUp(pqe.getPQueueIdx());

            }

        }
    }

    public PriorityQueueElement getMin() {
        return arr[0];
    }

    public void display() {
        int i;
        for (i = 0; i < this.idx; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public boolean isEmpty(){
        return this.idx == 0;                 
    }

}
