/* Holds array related problems and solutions */
public class Arrays {

  /* Largest and second largest number of the array */
  public static ArrayList<Integer> largestAndSecondLargest(int arr[]) {
      int sizeOfArray = arr.length;
      ArrayList<Integer> largestAndSecondLargest = new ArrayList<>(2);
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
}
