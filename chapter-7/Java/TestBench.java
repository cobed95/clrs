import java.util.*;

public class TestBench {
    public static void main(String[] args) {
        int[] array = {8, 4, 1, 7, 3, 6, 2, 3, 6, 9, 0};
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
