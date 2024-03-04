public class CycleSort {

    /* Cycle sort considering the duplicates elements in the array */
	public static void cycleSort(int arr[]) {
		int n = arr.length;
		int writes = 0;
		for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
			int item = arr[cycleStart];
			int pos = cycleStart;
			for (int i = cycleStart + 1; i < n; i++)
				if (arr[i] < item)
					pos++;
			if (pos == cycleStart)
				continue;
			while (item == arr[pos])
				pos += 1;
			if (pos != cycleStart) {
				swap(arr, cycleStart, pos);
				writes++;
			}
			// Rotate rest of the cycle
			while (pos != cycleStart) {
				pos = cycleStart;
				for (int i = cycleStart + 1; i < n; i++)
					if (arr[i] < item)
						pos += 1;
				while (item == arr[pos])
					pos += 1;
				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
					writes++;
				}
			}
		}
	}
}
