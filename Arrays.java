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

  public static List<Integer> leaders(int arr[], int n){
        int leader = 0;
        int count = 0;
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
}
