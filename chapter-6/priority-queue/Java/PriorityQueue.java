public class PriorityQueue {
    private Heap heap;
    
    public PriorityQueue(Event[] array) {
        this.heap = new Heap(array);
    }

    public Event getMaximum() {
        return this.heap.get(0);
    }

    public Event extractMaximum() {
        if (this.heap.getHeapSize() < 1) {
            System.out.println("Heap underflow while extractMaximum(): returning null");
            return null;
        }
        Event max = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.getHeapSize() - 1));
        this.heap.decrementHeapSize();
        this.heap.maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int key) {
        Event event = this.heap.get(i);
        if (event.key > key) {
            System.out.println("Key small than key of event at increaseKey()");
            return;
        }
        event.key = key; 
        while (i > 0 && this.heap.get(Heap.parent(i)).key < this.heap.get(i).key) {
            this.heap.swap(i, Heap.parent(i));
            i = Heap.parent(i);
        }
    }

    public void insert(Event event) {
        this.heap.incrementHeapSize();
        this.heap.set(this.heap.getHeapSize() - 1, event);
    }

    public int getHeapSize() {
        return this.heap.getHeapSize();
    }

    public String toString() {
        return this.heap.toString();
    }
}
