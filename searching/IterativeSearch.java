public class IterativeSearch{
        
    public static int search(int arr[], int x)
    {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) 
                return i;
        }
        return -1;
    }

    /* Finds the peak element of the array */
    public static int findPeak(int arr[])
	{
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

	/* Finds floor of sqrt of the given number */
	public static int floorSqrt(int x)
	{
		// Base cases
		if (x == 0 || x == 1)
			return x;
		int i = 1, result = 1;
		while (result <= x) {
			i++;
			result = i * i;
		}
		return i - 1;
	}

	/* Finds first and last occurance of the given number in array */
	public static void findFirstAndLast(int arr[], int x)
	{
		int n = arr.length;
		int first = -1, last = -1;
		for (int i = 0; i < n; i++) {
			if (x != arr[i])
				continue;
			if (first == -1)
				first = i;
			last = i;
		}
		if (first != -1) {
			System.out.println("First Occurrence = "+ first);
			System.out.println("Last Occurrence = " + last);
		}
		else
			System.out.println("Not Found");
	}
    
}
