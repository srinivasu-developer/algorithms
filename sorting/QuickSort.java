public class QuickSort {

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
}
