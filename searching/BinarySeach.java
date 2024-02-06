
public class BinarySeach {

	/* Search an element in a sorted array */
    public static int searchInSorted(int arr[], int k)
    {
		int n = arr.length;
        return searchInSorted(arr, 0, n - 1, k);
    }

	/* Search an element in a sorted array with recursion binary search */
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

	/* Search an element in a sorted array with iterative binary search */
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

	/* Finds floor of the given number in the array */
    public static int findFloor(long arr[], long x)
    {
		int n = arr.length;
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

	/* Finds left most index of the given number */
    public static int leftIndex(int arr[], int x)
    {
       int n = arr.length;
       int low = 0, high = n - 1, res = -1;
		while (low <= high) {
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;
			// If arr[mid] is same as x, we update res and move to the left half.
			else {
				res = mid;
				high = mid - 1;
			}
		}
		return res;
    }

	/* Finds right most index of the given number */
    public static int righIndex(int arr[], int x)
    {
       int n = arr.length;
       int low = 0, high = n - 1, res = -1;
		while (low <= high) {
			// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] <= x) {
				res = mid;
				low = mid + 1;
			}
		}
		return res;
    }

	/* Counts the number of times the given number occurred in a sorted array */
	public static int countOcc(int arr[], int x)
	{
		int first = leftIndex(arr, x);
		if(first == -1)
			return 0;
		else 
			return righIndex(arr, x) - first + 1;
	}

	/* Count ones in a binary sorted array */
	public static int countOnes(int arr[])
	{
		int n = arr.length;
		int low = 0, high = n - 1;
		while(low <= high)
		{
			int mid = (low + high) / 2;
			if(arr[mid] == 0)
				low = mid + 1;
			else
			{
				if(mid == 0 || arr[mid - 1] == 0)
					return (n - mid);
				else 
					high = mid -1;
			}
		}
		return 0;		
	}

	/* Find the peak element in the array */
	public static int findPeak(int arr[], int n)
	{
		// First or last element is peak element
		if (n == 1 || arr[0] >= arr[1])
			return 0;
		if (arr[n - 1] >= arr[n - 2])
			return n - 1;
		// Check for every other element
		for (int i = 1; i < n - 1; i++) {
			// Check if the neighbors are smaller
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
				return i;
		}
		return 0;
	}

	/* Finds the position of the target from an infinite sized array */
	public static int findPos(int[] arr, int target)
	{
		// first find the range, first start with a box of size 2
		int start = 0;
		int end = 1;
		// condition for the target to lie in the range
		while (target > arr[end]) {
			int temp = end + 1; // this is my new start
			// double the box value
			// end = previous end + sizeofbox*2
			end = end + (end - start + 1) * 2;
			start = temp;
		}
		return searchInSorted(arr, start, end, target);
	}
}
