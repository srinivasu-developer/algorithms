public class QuickSort {

    /* Naive partition */
    public static int naivePartition(int a[], int start, int high)
    {
        int temp[] = new int[(high - start) + 1];
        int pivot = a[high];
        int index = 0;
        // smaller number
        for (int i = start; i <= high; ++i) {
            if (a[i] < pivot) {
                temp[index++] = a[i];
            }
        }
        int position = index;
        // Placing the pivot to its original position
        temp[index++] = pivot;
        for (int i = start; i <= high; ++i) {
            if (a[i] > pivot) {
                temp[index++] = a[i];
            }
        }
        // Change the original array
        for (int i = start; i <= high; ++i) {
            a[i] = temp[i - start];
        }
        return position;
    }

    /* Lomuto partition */
    public static int lomutoPartition(int numbers[], int start, int last) {
        int pivot = numbers[last];
        int index = start - 1;
        int temp = 0;
        for (int i = start; i < last; ++i)
        {
            if (numbers[i] < pivot) {
                ++index;
                swapIndices(numbers, index, i);
            }
        }
        swapIndices(numbers, index, last);      
        return ++index;
    }

    private static void swapIndices(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /* Quick sort using naive partition method */
    public static void quicksortWithNaive(int numbers[], int start, int end)
    {
        if (start < end) {
            int point = naivePartition(numbers, start, end);
            quicksortWithNaive(numbers, start, point - 1);
            quicksortWithNaive(numbers, point + 1, end);
        }
    }
}
