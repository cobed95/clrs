import java.util.*;

public class Heap {
    private int[] array;
    private int heapSize;

    public Heap(int[] array) {
        this.array = array;
        this.heapSize = array.length;
        this.buildMaxHeap();
    }

    private void buildMaxHeap() {
        int parentOfLastLeaf = this.getParentOfLastLeaf();
        for (int i = parentOfLastLeaf; i >= 0; i--) {
            this.maxHeapify(i);
        }
    }

    public void maxHeapify(int i) {
        int left = this.getLeftIndex(i);
        int right = this.getRightIndex(i);

        int largest;
        if (left < this.heapSize && this.array[left] > this.array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < this.heapSize && this.array[right] > this.array[largest]) {
            largest = right;
        }

        if (largest != i) {
            this.swap(i, largest);
            this.maxHeapify(largest);
        }

    }

    public void swap(int i, int j) {
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private int getLeftIndex(int i) {
        return ((i + 1) * 2) - 1;
    }

    private int getRightIndex(int i) {
        return (i + 1) * 2;
    }

    private int getParentOfLastLeaf() {
        return this.getParentIndex(this.heapSize - 1);
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void decrementHeapSize() {
        this.heapSize -= 1;
    }
    
    public int[] getArray() {
        return this.array;
    }

    public String toString() {
        return Arrays.toString(this.array);
    }
}
