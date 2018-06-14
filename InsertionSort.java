package algo;

/**
 * Represents a {@code Insertion Sort} algorithm
 *
 * @author Srinivasu
 * On: 13th Jun 2018
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = sort(new int[]{10, 5, 9, 38, 5});
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }

    /**
     * Sorts the given array using Insertion Sort
     * Insertion Sort: Divides the array into sorted and unsorted parts by moving the unsorted elements into sorted portion.
     * <p>
     * Time complexity: O(n^2)
     *
     * @param array the array to sorted
     * @return a sorted array in an ascending order
     */
    private static int[] sort(int[] array) {
        int arrayLength = array.length;
        for (int i = 1; i < arrayLength; i++) {
            int element = array[i];
            for (int j = i - 1; j >= 0 && array[j] > element; j--) {
                array[j + 1] = array[j];
                array[j] = element;
            }
        }
        return array;
    }
}
