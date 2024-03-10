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
    
}
