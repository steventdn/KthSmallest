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
        mergeSort(list);
        return list[k-1];
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

     public static int medianOfMedians(int[] list, int low, int high){
        //if size <= 5 or 
        if(high <= 5){
            //find median 
             mergeSort(list);
             return list[2];
        } else {
            //if its > 5 (partition into subarrays of five and find median of each)
            int numOfArr = list.length/5;
           
            //mm array
            int[] mmArr = new int[numOfArr];
            //loop for number of subsets
            for(int i = 0; i<numOfArr; i++){
                int[] subset = new int[5];          //new subset
               
                System.arraycopy(list, i * 5, subset, 0, 5);
                //for each subset find the median and add to the mmArr
                mmArr[i] = medianOfMedians(subset, 0, subset.length - 1);
            }
            //lastly find the median of mmArr
            mergeSort(mmArr);
            return mmArr[mmArr.length/2];
        }
    }
  
    public static int mmPartition(int[] list, int low, int high, int mM){       
        int pivot = list[mM];
        //int swapper = (low - 1);
        int swapper = low;
        for (int i = low; i <= high - 1; i++)
        {
            //do not compare pivot with itself
            if(i == mM){
                i++;
            }
            if (list[i] <= pivot)
            {   
                //swapper++;
                swap(list, swapper, i);
                swapper++;
            }
        }
            //swapper++;
            swap(list, mM, swapper);
                
        return swapper;
    }
    
    public static int mmQuick(int[] list, int low, int high, int k){
        //get MM
        int pivot = medianOfMedians(list, 0, list.length - 1);

        //partition array with mM;
        int partition = mmPartition(list, low, high, pivot);
        //use MM to partition
        //int partition = mmPartition(list, low, high, pivot);
        if (partition == k){
            return list[partition];
        //if the current pivot index < kth - 1) (0-indexed) CHECK RIGHT SIDE OF PIVOT
        } else if (pivot > k) {
             return mmQuick(list, low, pivot - 1, k);
        //if the current pivot index > kth - 1) (0-indexed) CHECK LEFT SIDE OF PIVOT
        } else {
            return mmQuick(list, pivot + 1, high, k);
        }
    }
}
