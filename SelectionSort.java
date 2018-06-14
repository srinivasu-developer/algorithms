package algo;

/**
 * R the selection sort algorithm
 *
 * @author Srinivasu
 *         On 6/12/2018
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = sort(new int[]{10, 45, 20, 13, 20});
        for (int element : array) {
            System.out.println(element);
        }
    }

    /**
     * Sorts the given array using {@code SelectionSort}.
     * SelectionSort: Given an array it finds the smallest number from left to right. During the entire scan, it finds
     * the smallest number so it swaps the first element. Then starts the same from 2nd element and so on till the last
     * element of the array.
     * <p>
     * Time complexity: O(n^2)
     *
     * @param array the array to be sorted.
     * @return sorted array in ascending order
     */
    private static int[] sort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; ++i) {
            int currentMinimum = i;
            for (int j = i + 1; j < arrayLength; ++j) {
                if (array[currentMinimum] > array[j]) {
                    currentMinimum = j;
                }
            }
            int temp = array[i];
            array[i] = array[currentMinimum];
            array[currentMinimum] = temp;
        }
        return array;
    }
}
