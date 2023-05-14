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
    
    private void swap(int x,int y)
    {
        if(x >= 0 && y >= 0 && x < this.idx && y < this.idx)
        {
            PriorityQueueElement temp = this.arr[x];
            this.arr[x] = this.arr[y];
            this.arr[y] = temp;
            this.arr[x].setPQueueIdx(x);
            this.arr[y].setPQueueIdx(y);
            
        }
            
    }
    
    private void siftUp(int index)
    {
        int parentIdx = (index - 1 )/ 2 ;
        if(parentIdx < 0)
            return;
        System.out.println("Parent Index: " + parentIdx);
        if(arr[parentIdx].getPQueueKey() <= arr[index].getPQueueKey())
            return;
        swap(index,parentIdx);
        siftUp(parentIdx);
        
        
    }

    public void insert(PriorityQueueElement pqe){
        if(this.idx >= this.size)
            return;
        
        this.arr[this.idx] = pqe;
        pqe.addToPQueue();
        pqe.setPQueueIdx(this.idx);
        this.idx += 1;
        siftUp(this.idx - 1);
        this.display();
        
    }
    
    public void display()
    {
        int i;
        for(i = 0; i < this.idx;i++)
        {
            arr[i].display();
        }
    }
    

}
