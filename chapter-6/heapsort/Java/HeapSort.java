public class HeapSort {
    public static Heap sort(int[] array) {
        Heap heap = new Heap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            heap.swap(0, i);
            heap.decrementHeapSize();
            heap.maxHeapify(0);
        }
        return heap;
    }
}
