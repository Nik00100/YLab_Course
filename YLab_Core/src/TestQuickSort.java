import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestQuickSort {
    @org.junit.jupiter.api.Test
    void quickSort() {
        Integer[] array = {5,6,3,2,5,1,4,9};
        QuickSort.quickSort(array,0,array.length-1);
        Integer[] expected = {1,2,3,4,5,5,6,9};
        assertArrayEquals(expected,array);
    }
}
