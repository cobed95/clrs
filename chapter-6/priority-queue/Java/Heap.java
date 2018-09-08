import java.util.*;

public class Heap {
    private Event[] array;
    private int heapSize;

    public Heap(Event[] array) {
        this.array = array;
        this.heapSize = array.length;
        this.buildMaxHeap();
    }

    private void buildMaxHeap() {
        int parentOfLastLeaf = (this.heapSize - 1) / 2;
        System.out.println(parentOfLastLeaf);
        for (int i = parentOfLastLeaf; i >= 0; i--) {
            System.out.println(i);
            this.maxHeapify(i);
        }
    }
    
    public void maxHeapify(int i) {
        int left = ((i + 1) / 2) - 1;
        int right = (i + 1) / 2;

        int largest;
        if (left < this.heapSize && this.array[left].key > this.array[i].key) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < this.heapSize && this.array[right].key > this.array[largest].key) {
            largest = right;
        }

        if (largest != i) {
            this.swap(i, largest);
            this.maxHeapify(largest);
        }
    }
    
    public void swap(int i, int j) {
        Event temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public Event get(int i) {
        return this.array[i];
    }

    public void set(int i, Event event) {
        this.array[i] = event;
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    public boolean isFull() {
        return this.heapSize == this.array.length;
    }
    
    public void decrementHeapSize() {
        if (this.isEmpty()) {
            System.out.println("Cannot decrease heapSize. It is already 0.");
            return;
        } else if (this.heapSize < this.array.length / 2) {
            this.shrink();
        }
        this.heapSize--;
    }

    public void shrink() {
        Event[] newArray = new Event[this.array.length / 2];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public void incrementHeapSize() {
        if (this.heapSize == this.array.length) {
            this.expand();
        }
        this.heapSize++;
    }

    private void expand() {
        Event[] newArray = new Event[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public static int parent(int i) {
        return i / 2;
    }

    public static int left(int i) {
        return ((i + 1) * 2) - 1;
    }

    public static int right(int i) {
        return (i + 1) * 2;
    }

    public String toString() {
        return Arrays.toString(this.array);        
    }
}
