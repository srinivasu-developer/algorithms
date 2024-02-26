public class Problems {

    /* Finds the Kth smallest number in the given array */
    public static int kthSmallest(int arr[], int n, int k) {
        int low = 0, high = n - 1;
        while(low <= high) {
            int partition = lomutoPartition(arr, low, high);
            if(partition == k - 1) {
                return arr[partition];
            } else if (partition > k - 1) {
                high = partition - 1;
            } else {
                low = partition + 1;
            }
        }
        return -1;
    }

    public static int MinimumDifference(int arr[], int n) {
        Arrays.sort(arr);
        int res = arr[1] - arr[0];
        for(int i = 2; i < n; i++) {
            res = Math.min(res, arr[i] - arr[i - 1]);
        }
        return res;
    }

    private static int lomutoPartition(int arr[], int low, int high) {
        int pivot = arr[high];
        int index = low - 1;
        for(int i = low; i < high; i++) {
            if(arr[i] < pivot) {
            swap(arr, ++index, i);
            }
        }
        swap(arr, high, ++index);
        return index;
    }

    private static void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
  
}
