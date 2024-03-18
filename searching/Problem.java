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

	/* Count the number of occurances of given number x in the array */
	public static int countOcc(int arr[], int x) {
		int first = firstOcc(arr, x);
		if(first == -1)
			return 0;
		else 
			return lastOcc(arr, x) - first + 1;
	}

	/* Returns floor of square root of x */
	public static int floorSqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		// Starting from 1, try all numbers until i*i is greater than or equal to x.
		int i = 1, result = 1;
		while (result <= x) {
			result = ++i * i;
		}
		return i - 1;
	}

	/* Returns floor of square root of x with binary search */
	public static int floorSqrtBinarySearch(int x) {
		if (x == 0 || x == 1)
			return x;
		long start = 1, end = x / 2, ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == x)
				return (int) mid;
			// Since we need floor, we update answer when mid*mid is smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			}
			else // If mid*mid is greater than x
				end = mid - 1;
		}
		return (int) ans;
	}

	/* Simple binary search algorithm */
	public static int binarySearch(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l)/2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(arr, l, mid-1, x);
			return binarySearch(arr, mid+1, r, x);
		}
		return -1;
	}

	/**
 	* Method takes an infinite size array and a key to be searched and returns its position if found else -1.
	* We don't know size of arr[] and we can assume size to be infinite in this function.
	* NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING 
 	*/
	public static int findPos(int arr[], int key) {
		int l = 0, h = 1;
		int val = arr[0];
		// Find h to do binary search
		while (val < key) {
			l = h;
			if(2 * h < arr.length-1)
				h = 2*h;			
			else
				h = arr.length-1;
			val = arr[h];
		}
		return binarySearch(arr, l, h, key);
	}

	/** Finds the peak element of the given unsorted array 
 	* A peak element is an element whose neighbors have value smaller than that of the element. 
  	*/
	public static int findPeak(int arr[]) {
		int n = arr.length;
		if(n == 1)
			return arr[0];
		if(arr[0] >= arr[1])
			return arr[0];
		if(arr[n - 1] >= arr[n - 2])
			return arr[n - 1];

		for(int i = 1; i < n - 1; i++)
			if(arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
				return arr[i];
				
		return -1;
	}

	public static int findPeakOptimized(int arr[]) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
				return mid;
			if(mid > 0 && arr[mid - 1] >= arr[mid])
				high = mid -1;
			else
				low = mid + 1;
		}
		return -1;
	}

	/* Finds the median of the 2 given arrays */
	public static double median(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		if (n > m)
			return Median(B, A); // Swapping to make A smaller
		int start = 0;
		int end = n;
		int realmidinmergedarray = (n + m + 1) / 2;
		while (start <= end) {
			int mid = (start + end) / 2;
			int leftAsize = mid;
			int leftBsize = realmidinmergedarray - mid;
			int leftA = (leftAsize > 0) ? A[leftAsize - 1] : Integer.MIN_VALUE; // checking overflow of indices
			int leftB = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
			int rightA = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
			int rightB = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;
			// if correct partition is done
			if (leftA <= rightB && leftB <= rightA) {
				if ((m + n) % 2 == 0)
					return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
				return Math.max(leftA, leftB);
			}
			else if (leftA > rightB) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		return 0.0;
	}
    
}
