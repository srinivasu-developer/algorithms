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
    
}
