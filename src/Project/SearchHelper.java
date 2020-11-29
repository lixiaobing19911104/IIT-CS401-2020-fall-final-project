package Project;

/**
 * search algorithm
 */
public class SearchHelper {


    public static <T extends Comparable> int exhaustiveSearch(T arr[], T x) {
//		This method takes array (unsorted or sorted) as input with a search element.
        int n    = arr.length;
        int step = 0;
        for (int i = 0; i < n; i++) {
            boolean found = arr[i].equals(x);
            if (found == true) {
                System.out.println("In the unsorted array, the item is found: " + x + " at " + step + "th step.");
                break;
            } else if (found == false && i == n - 1) {
                System.out.println("In the unsorted array, the item " + x + " is not found.");
            }
            step++;

        }

        return step;
    }


    public static <T extends Comparable> int binarySearch(T[] sortedArray, T value) {
//		This method takes only sorted array as input with a search element
//		for example, your array cannot be {4,2,3,1}, it has to be sorted in ascending order {1,2,3,4}
//		Ensure you find the worst case scenario for this method before coming to a conclusion 
        int index = -1;
        int low   = 0;
        int high  = sortedArray.length;
        int Step  = 0;

        while (low <= high) {
            Step++;
            int mid = (low + high) / 2;
            if (sortedArray[mid].compareTo(value) < 0) {
                low = mid + 1;
            } else if (sortedArray[mid].compareTo(value) > 0) {
                high = mid - 1;
            } else {
                index = mid;
                System.out.println("In the sorted array, the item is found: " + value + " at " + Step + "th step.");
                break;
            }
            if (low > high) {
                System.out.println("In the sorted array, the item " + value + " is not found.");
            }


            //O(log2N)
        }
        return Step;
    }
}
