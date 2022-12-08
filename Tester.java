import java.util.Random;
class Tester{
    public static void main(String[] args) {
       //int[] list = {1,2,3,4,5,6,7,8,9,10};
       //int[] list = {1,2,3,4,5,6,7,8,9,10,
                    //  11,12,13,14,15,16,17,18,19,20,
                    //  21,22,23,24,25,26,27,28,29,30,
                    //  31,32,33,34,35,36,37,38,39,40,
                    // 41,42,43,44,45,46,47,48,49,50};
        //int[] nSizes = {5, 10, 50, 100, 500, 1000};
        int[] nSizes = {5, 10};
        for(int nSize: nSizes){
            int[] list = new int[nSize]; 
            int start = 1;
            for(int i = 0; i<nSize; i++){
                list[i] = start;
                start++;
            }
            System.out.println("\n\nMerge");
            System.out.println("Size" + nSize);
            System.out.println("The Kth (k = 1)" + KthSmallest.algoOne(list, 1));
            System.out.println("The Kth (k = n/4)" + KthSmallest.algoOne(list, list.length / 4 ));
            System.out.println("The Kth (k = n/2)" + KthSmallest.algoOne(list, list.length / 2 ));
            System.out.println("The Kth (k = 3n/4)" + KthSmallest.algoOne(list, (3*list.length) / 4 ));
            System.out.println("The Kth (k = n)" + KthSmallest.algoOne(list, list.length));

            System.out.println("Iterative Quick");
            System.out.println("Size" + nSize);
            System.out.println("The Kth (k = 1)" + KthSmallest.iterativeQuick(list, 0, list.length - 1, 1));
            System.out.println("The Kth (k = n/4)" + KthSmallest.iterativeQuick(list, 0, list.length - 1, list.length / 4));
            System.out.println("The Kth (k = n/2)" + KthSmallest.iterativeQuick(list, 0, list.length - 1, list.length / 2));
            System.out.println("The Kth (k = 3n/4)" + KthSmallest.iterativeQuick(list, 0, list.length - 1, (3*list.length) / 4 ));
            System.out.println("The Kth (k = n)" + KthSmallest.iterativeQuick(list, 0, list.length - 1, list.length ));

            System.out.println("Recursive Quick");
            System.out.println("Size" + nSize);
            System.out.println("The Kth (k = 1)" + KthSmallest.recursiveQuick(list, 0, list.length - 1, 1));
            System.out.println("The Kth (k = n/4)" + KthSmallest.recursiveQuick(list, 0, list.length - 1, list.length / 4));
            System.out.println("The Kth (k = n/2)" + KthSmallest.recursiveQuick(list, 0, list.length - 1, list.length / 2));
            System.out.println("The Kth (k = 3n/4)" + KthSmallest.recursiveQuick(list, 0, list.length - 1, (3*list.length) / 4 ));
            System.out.println("The Kth (k = n)" + KthSmallest.recursiveQuick(list, 0, list.length - 1, list.length ));

            System.out.println("Array" + KthSmallest.mmQuick(list, 0, list.length - 1, 1));
            System.out.println(KthSmallest.medianOfMedians(list, 0, list.length - 1));
        } 
    }
}
      
/* 
        for(int i = 0; i<list.length; i++){
            list[i] = rand.nextInt(10);
        }

        System.out.println("Before");
        for(int i = 0; i<list2.length; i++){
            System.out.println(list2[i]);
        }
        */
        //Merge
        //KthSmallest.mergeSort(list);

        
        //System.out.println("Third: " + KthSmallest.mmQuick(list2, 0, list2.length - 1, 7));
        //Quick (rec)
        //System.out.println(KthSmallest.recursiveQuick(list, 0, list.length - 1, 3));
        //KthSmallest.recursiveQuickSort(list, 0, list.length - 1, 0);
        // System.out.println("After");
        // for(int i = 0; i<list.length; i++){
        //     System.out.println(list[i]);
        // }

        
        //System.out.println("Merge");
        //System.out.println("The smallest is: " + KthSmallest.algoOne(list, 0));
        //int[] kSizes = {1, size/4, size/2, 3*size/4, size - 1};
        //for(int kSize: kSizes){
        //System.out.println("The" + kSize + "smallest is: " + KthSmallest.algoOne(list, kSize));
        //}

       // 

