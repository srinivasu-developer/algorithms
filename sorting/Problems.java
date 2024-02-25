public class Problems {

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
