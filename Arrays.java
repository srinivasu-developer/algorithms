/* Holds array related problems and solutions */
public class Arrays {

  /* Largest and second largest number of the array */
  public static ArrayList<Integer> largestAndSecondLargest(int arr[])
    {
        int sizeOfArray = arr.length;
        ArrayList<Integer> largestAndSecondLargest = new ArrayList<>(2);
        int largest = 0;
        int second = -1;
        for(int i = 0; i < sizeOfArray; i++) {
            if (arr[i] > arr[largest]) {
                second = largest;
                largest = i;
            } else if (arr[i] == arr[largest]) {
                continue;
            } else if (second == -1 || arr[i] > arr[second]) {
                second = i;
            }
        }
        int secondLargest = second == -1 ? -1 : arr[second];
        largestAndSecondLargest.add(arr[largest]);
        largestAndSecondLargest.add(secondLargest);
        return largestAndSecondLargest;
    }
}
