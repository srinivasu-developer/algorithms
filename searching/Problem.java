public class Problem {

    /** Given an array arr of size N and an element k. The task is to find the count of elements in the array that
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

    /** Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as the largest element 
    * K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing). 
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
    
}
