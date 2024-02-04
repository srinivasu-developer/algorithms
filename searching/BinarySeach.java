
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

    public static int searchInSortedIterative(int arr[], int k)
    {
        int lower = 0;
        int end = arr.length - 1;
        int result = -1;
        while(lower <= end) {
            int middle = (lower + end) / 2;
            if(arr[middle] == k) {
                result = 1;
                break;
            } else if (arr[middle] > k) {
                end = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return result;
    }
    
    public static int findFloor(long arr[], int n, long x)
    {
        int lower = 0;
        int end = n - 1;
        int middle;
        int result = -1;
        if(arr[end] <= x) {
            return end;
        }
        while (lower <= end) {
            middle = (lower + end) / 2;
            if(arr[middle] == x || (arr[middle] < x && arr[middle + 1] > x)) {
                result = middle;
                break;
            } else if (arr[middle] > x) {
                end = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return result;
        
    }
}
