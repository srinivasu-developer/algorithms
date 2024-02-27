public class Problems {

    /* Finds the Kth smallest number in the given array */
    public static int kthSmallest(int arr[], int k) {
        int n = arr.length;
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

    /* Finds the minimum difference of 2 elements in the given array with quadratic time complexity */
    public static int findMinDiff(int[] arr) {
        int n = arr.length;
		int diff = Integer.MAX_VALUE;
		// Find the min diff by comparing difference of all possible pairs in given array
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (Math.abs((arr[i] - arr[j])) < diff)
					diff = Math.abs((arr[i] - arr[j]));
		return diff;
	}

    /* Finds the minimum difference of 2 elements in the given array an effecient approach */
    public static int minimumDifference(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = arr[1] - arr[0];
        for(int i = 2; i < n; i++) {
            res = Math.min(res, arr[i] - arr[i - 1]);
        }
        return res;
    }

    /* Sort the given binary array */
    public static void binarySort(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            if(arr[low] == 1) {
                swap(arr, low, high--);
            } else {
                ++low;
            }
        }
    }

	/* Sort the array having 3 different elements in our case, it's 0, 1 and 2; this approach is having 2 traversals of the array */
	public static void sortArr012(int arr[]) {
		int n = arr.length;
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;
        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < n; i++) {
            switch (arr[i]) {
            case 0:
                cnt0++;
                break;
            case 1:
                cnt1++;
                break;
            case 2:
                cnt2++;
                break;
            }
        }
        i = 0;
        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }
        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }
        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }
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
