package Project;

/**
 * sort helper to implement different sorting algorithm
 */
public class SortHelper {

    /**
     * bubble sort algorithm implementation
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] bubbleSort(T[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j]     = temp;
                }
            }
        }
        return arr;
    }

}
