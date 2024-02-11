/* Holds array related problems and solutions */
public class Arrays {

  /* Largest and second largest number of the array */
  public static List<Integer> largestAndSecondLargest(int arr[]) {
      int sizeOfArray = arr.length;
      List<Integer> largestAndSecondLargest = new ArrayList<>(2);
      int largest = 0;
      int second = -1;
      for(int i = 0; i < sizeOfArray; i++) {
          if (arr[i] > arr[largest]) {
              second = largest;
              largest = i;
          } else if (arr[i] != arr[largest] && (second == -1 || arr[i] > arr[second])) {
              second = i;
          }
      }
      largestAndSecondLargest.add(arr[largest]);
      largestAndSecondLargest.add(second < 0 ? second : arr[second]);
      return largestAndSecondLargest;
  }

  /* Insert an element at the end of the given array */
  public void insertAtEnd(int arr[], int element) {
      arr[arr.length - 1] = element;
  }

  /* Insert an element at specified index */
  public void insertAtIndex(int arr[], int index, int element) {
      int sizeOfArray = arr.length;
      if(index != sizeOfArray - 1) {
          for(int temp = sizeOfArray - 1; temp > index; temp--) {
              arr[temp] = arr[temp - 1];
          }
      }
      arr[index] = element;
  }

  /* Finds all the leaders of the given array */
  public static List<Integer> leaders(int arr[]) {
      int leader = 0;
      int count = 0;
      int n = arr.length;
      for(int i = n - 1, j = n - 1; i >= 0; i--) {
          if(arr[i] >= leader) {
              leader = arr[i];
              arr[j--] = leader;
              count++;
          }
      }
      List<Integer> leaders = new ArrayList<>(count);
      for(int i = n - count; i < n; i++) {
          leaders.add(arr[i]);
      }
      return leaders;
  }

	/* Check if array is sorted in non-decreasing order */
	public static boolean arraySortedOrNot(int arr[]) { 
		int n = arr.length;
		if (n != 0 && n != 1) {
		  for (int i = 1; i < n; i++) {
		if (arr[i - 1] > arr[i])
			return false;
		  }
		}
		return true;
	}
	
	/* Reverse array in place */
	public static void rvereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}	
	
	/* Remove duplicates from a sorted array */
	public static int remDups(int arr[]) {
		int n = arr.length;
		int res = 1;
		for(int i = 1; i < n; i++) {
			if(arr[res - 1] != arr[i]) {
				arr[res] = arr[i];
				res++;
			}
		}
		return res;
	}

	/* Move all zeros to the end of the array */
	public static void moveZerosToEnd(int arr[]) {
		int n = arr.length;
		// Count of non-zero elements
		int count = 0;
		// Traverse the array. If arr[i] is non-zero, then
		// update the value of arr at index count to arr[i]
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i];
		// Update all elements at index >=count with value 0
		for (int i = count; i<n;i++)
			arr[i]=0;
	}

	/* Find max profit from the array of prices */
	public static int maxProfit(int price[])
    {
		int n = price.length;
    	int profit = 0;
    	for(int i = 1; i < n; i++)
    	{
    		if(price[i] > price[i - 1])
    			profit += price[i] - price[i -1];
    	}
    	return profit;
    }

	/* Find max number of consecutive 1's in the given array */
	public static int countConsecutiveOnce(int arr[]) {
        int n = arr.length;
        int count = 0;
        int intermediate = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                intermediate++;
                count = Math.max(count, intermediate);
            } else {
                intermediate = 0;
            }
        }
        return count;
    }

	/* FINDS the equilibruim point where sum of left and right elements are same */
	public static int equilibriumPoint(long arr[], int n) {
        long sum = calculateSum(arr);
        long leftCount = 0L;
        for(int i = 0; i < n; i++) {
            sum -= arr[i];
            if(sum == leftCount) {
                return i + 1;
            }
            leftCount += arr[i];
        }
        return -1;
    }

	/* Prints the maximum of the adjacent numbers */
	public astatic void maximumAdjacent(int sizeOfArray, int arr[]){
        for(int i = 0; i < sizeOfArray - 1; i++) {
            System.out.print(Math.max(arr[i], arr[i + 1]) + " ");
        }
    }

	/* Finds the majority among given x and y in the array. If both have equal frequency, the smaller number is the majority one */
	public int majorityWins(int arr[], int x, int y) {
		int n = arr.length;
        int xCount = 0;
        int yCount = 0;
        if(x == y) {
            return x;
        }
        for(int i = 0; i < n; i++) {
            if(arr[i] == x) {
                xCount++;
            } else if (arr[i] == y) {
                yCount++;
            }
        }
        if(xCount > yCount) {
            return x;
        } else if(xCount < yCount) {
            return y;
        } else {
            return Math.min(x, y);
        }
    }

	/* Finds longest subarray of even odds in the given array */
	public static int maxEvenOdd(int arr[])
    {
		int n = arr.length;
        int maxLength = 1;
        int current = 1;
        for(int i = 1; i < n; i++) {
            if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || 
                (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                current++; 
                maxLength = Math.max(maxLength, current);
            } else {
                current = 1;
            }
        }
        return maxLength;
    }

	/* Converts the given sorted array to a wave array */
	public static void convertToWave(int[] a) {
		int n = a.length;
        int temp = 0;
        for(int i = 0; i < n - 1; i = i + 2) {
            temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
        }
    }

	/* Function to find the trapped water between the blocks. */
    public static long trappingWater(int arr[]) { 
		int n = arr.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = arr[0];
        for (int i = 1; i < n - 1; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        } 
        rmax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
        }
        long result = 0L;
        for(int i = 1; i < n - 1; i++) {
            result += (Math.min(rmax[i], lmax[i]) - arr[i]);
        }
        return result;
    } 

	/* Max sum with a sliding k elements subarray */
	public static int maxSum(int arr[], int k)
    {
		int n = arr.length;
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];
        int max_sum = curr_sum;
        for (int i = k; i < n; i++) {
            curr_sum += (arr[i] - arr[i - k]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }

	/* The group flips and number of less flips */
	public static void printGroups(int arr[]) {
		int n = arr.length;
		// Traverse through all array elements starting from the second element
		for(int i = 1; i < n; i++)
		{	
		// If current element is not same as previous
			if (arr[i] != arr[i - 1])
			{
				// If it is same as first element then it is starting of the interval to be flipped.
				if (arr[i] != arr[0])
					System.out.print("From " + i + " to ");
				// If it is not same as previous and same as first element, then previous element is end of interval
				else
					System.out.println(i - 1);
			}
		}
		// Explicitly handling the end of last interval
		if (arr[n - 1] != arr[0])
			System.out.println(n - 1);
	}

	/* Sub array with max sum */
	public static void subarrayWithMaxSum(Vector<Integer> nums) {
		// Initialize currMax and globalMax with first value of nums
		int endIndex = 0, currMax = nums.get(0);
		int globalMax = nums.get(0);
		// Iterate for all the elements of the array
		for (int i = 1; i < nums.size(); ++i)
		{
			currMax = Math.max(nums.get(i), nums.get(i) + currMax);
			// Check if currMax is greater than globalMax
			if (currMax > globalMax)
			{
				globalMax = currMax;
				endIndex = i;
			}
		}
		int startIndex = endIndex;
		// Traverse in left direction to find start Index of subarray
		while (startIndex >= 0)
		{
			globalMax -= nums.get(startIndex);
			if (globalMax == 0)
				break;
			startIndex--;
		}
		for(int i = startIndex; i <= endIndex; ++i) {
			System.out.print(nums.get(i) + " ");
		}
	}

	/* Function to find the maximum occurred integer in all ranges. */
    public static int maxOccured(int L[], int R[], int maxx){
		int n = L.length;
        int[] freq = new int[maxx + 1];
        for(int i = 0; i < n; i++) {
            freq[L[i]]++;
            freq[R[i] + 1]--;
        }
        int preSum = freq[0];
        int result = 0;
        for(int i = 1; i < maxx + 1; i++) {
            freq[i] += freq[i - 1];
            if(freq[i] > preSum) {
                preSum = freq[i];
                result = i;
            }
        }
        return result;
    }

	/* Finds the min adjucent difference */
	public static int minAdjDiff(int arr[]) {
		int n = arr.length;
        if (n < 2) 
            return 0; 
        int res = Math.abs(arr[1] - arr[0]); 
        for (int i = 2; i < n; i++) 
            res = Math.min(res, Math.abs(arr[i] - arr[i - 1])); 
  
        // Checking circular link 
        return Math.min(res, Math.abs(arr[n - 1] - arr[0])); 
        
    }

	/* Left rotates by one position */
	public static void lRotateOne(int arr[])
    {
		int n = arr.length;
    	int temp = arr[0];
    	for(int i = 1; i < n; i++)
    	{
    		arr[i - 1] = arr[i];
    	}
    	arr[n - 1] = temp;
    }

	/* Left rotates by d positions */
	public static void leftRotate(int arr[], int d)
    {
		int n = arr.length;
    	for(int i = 0; i < d; i++)
    	{
    		lRotateOne(arr, n);
    	}
    }

	public void printLeaders(int arr[])
	{
		int size = arr.length;
		for (int i = 0; i < size; i++)
		{
			int j;
			for (j = i + 1; j < size; j++)
			{
				if (arr[i] <=arr[j])
					break;
			}
			if (j == size) // the loop didn't break
				System.out.print(arr[i] + " ");
		}
	}
}
