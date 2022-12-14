import java.util.ArrayList;
import java.util.*;

public class KthSmallest {
  // Merge Sort
  // Time Complexity O(nlogn)
  public int[] arrayGen(int size) {
    Random r = new Random();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = r.nextInt(10);
    }
    return arr;
  }

  public void mergeSort(int[] list) {
    int n = list.length;
    if (n < 2) {
      return;
    }
    int middle = n / 2;

    // split
    int[] leftHalf = new int[middle];
    int[] rightHalf = new int[n - middle];

    // Save into respective sides
    for (int i = 0; i < middle; i++) {
      leftHalf[i] = list[i];
    }
    for (int i = middle; i < n; i++) {
      rightHalf[i - middle] = list[i];
    }

    // Recursive Calls
    mergeSort(leftHalf);
    mergeSort(rightHalf);
    merge(list, leftHalf, rightHalf);

  }

  public void merge(int[] list, int[] leftHalf, int[] rightHalf) {
    int leftN = leftHalf.length;
    int rightN = rightHalf.length;
    int i = 0, j = 0, k = 0;
    // while both arrays have elements to parse
    while (i < leftN && j < rightN) {
      if (leftHalf[i] <= rightHalf[j]) {
        list[k] = leftHalf[i];
        i++;
      } else {
        list[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    while (i < leftN) {
      list[k] = leftHalf[i];
      k++;
      i++;
    }
    while (j < rightN) {
      list[k] = rightHalf[j];
      k++;
      j++;
    }
  }

  // ALGO 1 (SORT THE LIST (mergeSort) AND THEN RETURN KTH SMALLEST)
  public int algoOne(int[] list, int k) {
    mergeSort(list);
    return list[k - 1];
  }

  public int partition(int[] arr, int low, int high) {

    int pivot = arr[high];
    // int swapper = (low - 1);
    int swapper = low;
    for (int i = low; i <= high - 1; i++) {
      if (arr[i] <= pivot) {
        // swapper++;
        swap(arr, swapper, i);
        swapper++;
      }
    }
    // swapper++;
    swap(arr, high, swapper);

    return swapper;
  }

  public int iterativeQuick(int[] arr, int low, int high, int k) {

    while (low <= high) {
      int partition = partition(arr, low, high);
      if (partition == k - 1) {
        return arr[partition];
        // if the current pivot index < kth - 1) (0-indexed) CHECK RIGHT SIDE OF PIVOT
      } else if (partition < k - 1) {
        low = partition + 1;
        // if the current pivot index > kth - 1) (0-indexed) CHECK LEFT SIDE OF PIVOT
      } else {
        high = partition - 1;
      }
    }
    // can not find
    return -1;
  }

  public int recursiveQuick(int[] arr, int low, int high, int k) {
    // get the current pivot and partition array
    int partition = partition(arr, low, high);
    // if the current pivot index == kth - 1 (0-indexed) MATCH
    if (partition == k - 1) {
      return arr[partition];
      // if the current pivot index < kth - 1) (0-indexed) CHECK RIGHT SIDE OF PIVOT
    } else if (partition < k - 1) {
      return recursiveQuick(arr, partition + 1, high, k);
      // if the current pivot index > kth - 1) (0-indexed) CHECK LEFT SIDE OF PIVOT
    } else {
      return recursiveQuick(arr, low, partition - 1, k);
    }
  }

  public int[] swap(int[] list, int swap1, int swap2) {
    int temp = list[swap1];
    list[swap1] = list[swap2];
    list[swap2] = temp;
    return list;
  }

  public int getMedian(int arr[], int i,int n){
    //Sort the array  
    Arrays.sort(arr, i, n);
    //return Median
    return arr[i+(n-i)/2];                    
  }
  
  
public int medianOfMedians(int arr[], int start, int end, int k)
{
    if (k > 0 && k <= end - start + 1)
    {
        //start to end (will not always be 0 - n)
        int n = end - start + 1 ; 
        //Divide into subarrays of Size 5
        //Find med[i] = median of each subarray
        int i;
         // There will be floor((n+4)/5) groups;
        int []median = new int[(n + 4) / 5];
        for (i = 0; i < n/5; i++)
            median[i] = getMedian(arr, start+i*5, start+i*5+5);
        // Catch the last subarray (may not be five)
        if (i*5 < n) 
        {
            median[i] = getMedian(arr, start+i*5, start+i*5+n%5); 
            i++;
        } 
        // FIND MM
        int medOfMed = (i == 1)? median[i - 1]: medianOfMedians(median, 0, i - 1, i / 2);
        //Use MM
        int pos = mmPartition(arr, start, end, medOfMed);
        // Found K
        if (pos-start == k - 1)
            return arr[pos];
        //Left Side
        if (pos-start > k - 1) 
            return medianOfMedians(arr, start, pos - 1, k);
        // Right Size
        return medianOfMedians(arr, pos + 1, end, k - pos + start - 1);
    }
    return Integer.MAX_VALUE;
}
  

  
// Look for x in the array and move it to the end
// Partition the array around x
public int mmPartition(int arr[], int start, int end, int x){
  //Look for x
    int i;
    for (i = start; i < end; i++)
        if (arr[i] == x)
        break;
    //Move to end
    swap(arr, i, end);
  
    //Partition around x (end)
    i = start;
    for (int j = start; j <= end - 1; j++)
    {
        if (arr[j] <= x)
        {
            swap(arr, i, j);
            i++;
        }
    }
    //Move to middle
    swap(arr, i, end);
    return i;
}
  


}
  
  
  

