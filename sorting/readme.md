Sorting any sequence means to arrange the elements of that sequence according to some specific criterion.

In-Place Sorting: An in-place sorting algorithm uses constant extra space for producing the output (modifies the given array only). It sorts the list only by modifying the order of the elements within the list. 

## Insertion Sort
Insertion Sort is an In-Place sorting algorithm. This algorithm works in a similar way of sorting a deck of playing cards. 

The idea is to start iterating from the second element of array till last element and for every element insert at its correct position in the subarray before it. 

## Selection Sort
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

The subarray which is already sorted. 
Remaining subarray which is unsorted.

## Insertion Sort
Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

#### Characteristics of Insertion Sort:
* This algorithm is one of the simplest algorithm with simple implementation
* Basically, Insertion sort is efficient for small data values
* Insertion sort is adaptive in nature, i.e. it is appropriate for data sets which are already partially sorted.

## Merge Sort
A merge sort consists of several passes over the input. The first pass merges segments of size 1, the second merges segments of size 2, and the i-th pass merges segments of size 2i-1. Thus, the total number of passes is [log2n]. As merge showed, we can merge two sorted segments in linear time, which means that each pass takes O(n) time. Since there are [log2n] passes, the total computing time is O(nlogn).

#### Advantages of Merge Sort:
* Merge sort has a time complexity of O(n log n), which means it is relatively efficient for sorting large datasets.
* Merge sort is a stable sort, which means that the order of elements with equal values is preserved during the sort.
* It is easy to implement thus making it a good choice for many applications.
* It is useful for external sorting. This is because merge sort can handle large datasets, it is often used for external sorting, where the data being sorted does not fit in memory.
* The merge sort algorithm can be easily parallelized, which means it can take advantage of multiple processors or cores to sort the data more quickly.
* Merge sort requires relatively few additional resources (such as memory) to perform the sort. This makes it a good choice for systems with limited resources.

#### Drawbacks of Merge Sort:
* Slower compared to the other sort algorithms for smaller tasks. Although effecient for large datasets its not the best choice for small datasets.
* The merge sort algorithm requires an additional memory space of 0(n) for the temporary array. This is to store the subarrays that are used during the sorting process.
* It goes through the whole process even if the array is sorted.
* It requires more code to implement since we are dividing the array into smaller subarrays and then merging the sorted subarrays back together.

## Quick Sort
QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot(in case of lomuto partition). There are many different versions of quickSort that pick pivot in different ways. 
 
1. Always pick first element as pivot.
2. Always pick last element as pivot (implemented below)
3. Pick a random element as pivot.
4. Pick median as pivot.

## What is a stable sorting algorithm? 
A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input data set
