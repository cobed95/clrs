public class Heap {
    private Event[] array;
    private int heapSize;

    public Heap(Event[] array) {
        this.array = array;
        this.heapSize = array.length;
        this.buildMaxHeap();
    }

    private void buildMaxHeap() {
        int length = this.heapSize;
        for (int i = (length - 1) / 2; i >= 1; i--) {
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

    private void swap(int i, int j) {
        Event temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
}
