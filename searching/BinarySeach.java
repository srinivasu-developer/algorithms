
public class BinarySeach {
  
    public static int searchInSorted(int arr[], int n, int k)
    {
        return searchInSorted(arr, 0, n - 1, k);
    }
    
    private static int searchInSorted(int arr[], int lower, int end, int k) {
        if(lower > end) {
            return -1;
        }
        int middle = (lower + end) / 2;
        if(arr[middle] == k) {
            return 1;
        } else if(arr[middle] > k) {
            return searchInSorted(arr, lower, middle - 1, k);
        } else {
            return searchInSorted(arr, middle + 1, end, k);
        }
    }
}
