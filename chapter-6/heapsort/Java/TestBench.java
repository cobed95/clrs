import java.util.*;

public class TestBench {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
    
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Original Array: " + Arrays.toString(array));

        Heap heap = HeapSort.sort(array);
        System.out.println("After heapsort: " + heap.toString());
    }
}
