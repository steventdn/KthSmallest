import java.util.Random;
class Tester{
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nSizes = {10, 50, 100, 500, 1000};
      
        //for(int size : nSizes){
        int[] list = new int[5];  
        int[] list2 = {1,2,3,4,5};
        int size = list.length;  

        for(int i = 0; i<list.length; i++){
            list[i] = rand.nextInt(10);
        }

        System.out.println("Before");
        for(int i = 0; i<list.length; i++){
            System.out.println(list[i]);
        }
        //Merge
        //KthSmallest.mergeSort(list);

        System.out.println("Third: " + KthSmallest.recursiveQuick(list, 0, list2.length - 1, 2));
        System.out.println("Third: " + KthSmallest.iterativeQuick(list, 0, list2.length - 1, 2));
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

       // }
    }
}
