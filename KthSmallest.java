import java.util.ArrayList;
import java.util.*;   

public class KthSmallest {
    //Merge Sort
    //Time Complexity O(nlogn)
    public static void mergeSort(int[] list){
        int n = list.length;
        if(n < 2){
            return;
        }
        int middle = n/2;

        //split
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[n - middle];

        //Save into respective sides
        for(int i = 0; i<middle; i++){
            leftHalf[i] = list[i];
        }
        for(int i = middle; i<n; i++){
            rightHalf[i - middle] = list[i];
        }

        //Recursive Calls
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(list, leftHalf, rightHalf);

    }
    public static void merge(int[] list, int[] leftHalf, int[] rightHalf){
        int leftN = leftHalf.length;
        int rightN = rightHalf.length;
        int i = 0, j = 0, k = 0;
        //while both arrays have elements to parse
        while(i < leftN && j < rightN){
            if(leftHalf[i] <= rightHalf[j]){
                list[k] = leftHalf[i];
                i++;
            } else {
                list[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i < leftN){
            list[k] = leftHalf[i];
            k++;
            i++;
        }
        while(j < rightN){
            list[k] = rightHalf[j];
            k++;
            j++;
        }
    }

    //ALGO 1 (SORT THE LIST (mergeSort) AND THEN RETURN KTH SMALLEST)
    public static int algoOne(int[] list, int k){
        return list[k];
    }


    
    public static int partition(int[] arr, int low, int high){
       
        int pivot = arr[high];
        //int swapper = (low - 1);
        int swapper = low;
        for (int i = low; i <= high - 1; i++)
        {
            if (arr[i] <= pivot)
            {   
                //swapper++;
                swap(arr, swapper, i);
                swapper++;
            }
        }
            //swapper++;
            swap(arr, high, swapper);
             
        return swapper;
    }
    public static int iterativeQuick(int[] arr, int low, int high, int k){

        while(low <= high){
            int partition = partition(arr, low, high);
            if(partition == k - 1){
                return arr[partition];
            //if the current pivot index < kth - 1) (0-indexed) CHECK RIGHT SIDE OF PIVOT
            } else if (partition < k - 1) {
                low = partition + 1;
            //if the current pivot index > kth - 1) (0-indexed) CHECK LEFT SIDE OF PIVOT
            } else {
                high = partition - 1;
            }
        }
        //can not find
        return -1;
    }
    public static int recursiveQuick(int[] arr, int low, int high, int k){
        //get the current pivot and partition array
        int partition = partition(arr, low, high);
        //if the current pivot index == kth - 1 (0-indexed) MATCH
        if (partition == k - 1){
            return arr[partition];
        //if the current pivot index < kth - 1) (0-indexed) CHECK RIGHT SIDE OF PIVOT
        } else if (partition < k - 1) {
             return recursiveQuick(arr, partition + 1, high, k);
        //if the current pivot index > kth - 1) (0-indexed) CHECK LEFT SIDE OF PIVOT
        } else {
            return recursiveQuick(arr, low, partition - 1, k);
        }
    }

    private static void swap(int[] list, int swap1, int swap2){
        int temp = list[swap1];
        list[swap1] = list[swap2];
        list[swap2] = temp;
    }
  
    public static int medianOfMedians(int[] list, int k){
        //if size == 5 or less
        if(list.length <= 5){
            //find median of subset
             return recursiveQuick(list, 0, list.length - 1, list.length / 2);
        } else {
            //if its > 5 (partition into subarrays of five and find median of each)
            int numOfArr = list.length/5;
            //mm array
            int[] mmArr = new int[numOfArr];
            //loop for number of subsets
            for(int i = 0; i<numOfArr; i++){
                int index = i * 5;                      //place in OG array
                int[] subset = new int[5];              //new subset
                for(int j = index; j<index + 5; j++){   //start from 
                    subset[j] = list[index];
                }
                mmArr[i-1] = medianOfMedians(subset, subset.length / 2);
            }
        }
    }

    /*
     *  public static void recursiveQuickSort(int[] list, int low, int high){

        //Base Case (one element in the array)
        if(low >= high){
            return;
        }
        //chose the end num as pivot
        int pivot = list[high];

        int left_pointer = low;
        int right_pointer = high;

        while(left_pointer < right_pointer){
            //while the element on the left is less|equal to the pivot and still in bounds
            while(list[left_pointer] <= pivot & left_pointer < right_pointer){
                //increment left_pointer (check next)
                left_pointer++;
            }
            //while the element on the left is greater|equal to the pivot and still in bounds
            while(list[right_pointer] >= pivot & left_pointer < right_pointer){
                //increment right_pointer (check next)
                right_pointer--;
            }
            //after these while loops (list[left_pointer] > pivot) && (list[right_pointer] < pivot)
            swap(list, left_pointer, right_pointer);
        }
        //pointers have met at the middle (==) (swap left with the pivot int)
        swap(list, left_pointer, high);
        //start from 0 (start) high -> pivot pos - 1;
        recursiveQuickSort(list, low, left_pointer - 1);
        //start from pivot + 1 -> (end)high
        recursiveQuickSort(list, left_pointer + 1, high);
    }
    

     */

    /*
    //Quick Sort (partition until pivot is at the kth slot)
    //Best Case O(n) Worst Case O(n^2)
    public int secondAlgorithm(int k, ArrayList<Integer> list){

    }
    //Recursive Quicksort
    public int thirdAlgorithm(int k, ArrayList<Integer> list){

    }
    //Median of Medians
    public int fourthAlgorithm(int k, ArrayList<Integer> list){

    }
    */
}
