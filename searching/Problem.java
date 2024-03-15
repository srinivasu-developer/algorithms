public class Problem {

    /** Given an array arr of size N and an element k. It finds the count of elements in the array that
    * appear more than n/k times.
    */
    public int countOccurence(int[] arr, int k) {
        int n = arr.length;
        int desired = n / k;
        Map<Integer, Integer> countMap = new HashMap<>();
        int currentElement;
        int count = 0;
        int currentCount;
        for(int i = 0; i < n; i++) {
            currentElement = arr[i];
            countMap.putIfAbsent(currentElement, 0);
            currentCount = countMap.get(currentElement);
            countMap.put(currentElement, ++currentCount);
            if(currentCount == desired + 1) {
                ++count;
            }
        }
        return count;
    }

    /** 
    * Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as the largest element 
    * K in arr[] such that K is smaller than or equal to x. It finds the index of K(0-based indexing). 
    */
    public static int findFloor(long arr[], long x) {
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

    public static int leftIndex(int n, int arr[], int x) {  
       int low = 0, high = n - 1, res = -1;
		while (low <= high) {
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

	/**
 	* Given a binary sorted non-increasing array of 1s and 0s. If finds the count of 1s in the binary array
	*/
	public static int countOnes(int arr[]){
        int lastIndex = lastIndexOf(arr);
        if(lastIndex < 0) {
            return 0;
        }
        return ++lastIndex;
    }
	
	public static int lastIndexOfOne(int arr[]) {
        int low = 0, high = arr.length - 1;
        int mid;
        int result = -1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == 0) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }

	/* Finds the first occurance of the given number x */
	public static int firstOcc(int arr[], int x) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(x > arr[mid])
				low = mid + 1;
			else if(x < arr[mid])
				high = mid - 1;
			else {
				if(mid == 0 || arr[mid - 1] != arr[mid])
					return mid;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	/* Finds the last occurance of the given number x */
	public static int lastOcc(int arr[], int x) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(x > arr[mid])
				low = mid + 1;
			else if(x < arr[mid])
				high = mid - 1;
			else {
				if(mid == n - 1 || arr[mid + 1] != arr[mid])
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}
    
}
