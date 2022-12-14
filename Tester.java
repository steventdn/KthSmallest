
class Tester {
  public static void main(String[] args) {
    KthSmallest test = new KthSmallest();
    int[] nSizes = {10, 50, 100, 500, 1000, 5000};
  //test
  //new shit
       //For each n size 
    for (int nSize : nSizes) {
      //At each size we reset the Time
      double select1Avg = 0;
      double select2Avg = 0;
      double select3Avg = 0;
      double select4Avg = 0;

      for(int p = 0; p<1; p++){
        int[] kValues = {1, nSize/4, nSize/2, 3*nSize/4, nSize};
        int[] arr = test.arrayGen(nSize);
        // int[] arr = new int[nSize];
        // int start = 1;
        // for (int i = 0; i < nSize; i++) {
        //   arr[i] = start;
        //   start++;
        // }
        for(int s = 0; s<1; s++){

          //For each k Value in nSize
          for(int k: kValues){
          
            // Merge
            long startTime1 = System.nanoTime();
            test.algoOne(arr, k);
            long endTime1 = System.nanoTime();
            long totalTime1 = endTime1 - startTime1;
            select1Avg += totalTime1;
      
            // Iterative
            long startTime2 = System.nanoTime();
            test.iterativeQuick(arr, 0, arr.length - 1, k);
            long endTime2 = System.nanoTime();
            long totalTime2 = endTime2 - startTime2;
            select2Avg += totalTime2;
  
            // Recursive
            long startTime3 = System.nanoTime();
            test.recursiveQuick(arr, 0, arr.length - 1, k);
            long endTime3 = System.nanoTime();
            long totalTime3 = endTime3 - startTime3;
            select3Avg += totalTime3;
      
            // Median
            long startTime4 = System.nanoTime();
            test.medianOfMedians(arr, 0, arr.length - 1, k);
            long endTime4 = System.nanoTime();
            long totalTime4 = endTime4 - startTime4;
            select4Avg += totalTime4;
          }
        }
      }
      System.out.println("\n\n Size: " + nSize);
      System.out.println("Select 1 Avg Time:" + select1Avg/20000);
      System.out.println("Select 2 Avg Time:" + select2Avg/20000);
      System.out.println("Select 3 Avg Time:" + select3Avg/20000);
      System.out.println("Select 4 Avg Time:" + select4Avg/20000);
      System.out.println("hello");
    }
  }
}
        
      
       
        

  //CODE TO VERIFY PROGRAM CORRECTNESS
     
      // int[] nSizes = {10, 50, 100, 500, 1000, 5000};
      // for(int nSize: nSizes){
      //   int start = 1;
        
      //   int[] list = new int[nSize];
      //   for (int i = 0; i < list.length; i++) {
      //     list[i] = start;
      //     start++;
      //   }
        
      //   KthSmallest test = new KthSmallest();
        
      //   System.out.println("\n\nMerge");
      //   System.out.println("Size" + nSize);
        
      //   System.out.println("The Kth (k = 1)" + test.algoOne(list, 1));
       
      //   System.out.println("The Kth (k = n/4)" + test.algoOne(list,
      //   list.length / 4));
       
      //   System.out.println("The Kth (k = n/2)" + test.algoOne(list,
      //   list.length / 2));
        
      //   System.out.println("The Kth (k = 3n/4)" + test.algoOne(list, (3 *
      //   list.length) / 4));
      
      //   System.out.println("The Kth (k = n)" + test.algoOne(list,
      //   list.length));
    
      //   System.out.println("Iterative Quick");
      //   System.out.println("Size" + nSize);
      //   System.out.println("The Kth (k = 1)" + test.iterativeQuick(list, 0,
      //   list.length - 1, 1));
      //   System.out.println("The Kth (k = n/4)" + test.iterativeQuick(list, 0,
      //   list.length - 1, list.length / 4));
      //   System.out.println("The Kth (k = n/2)" + test.iterativeQuick(list, 0,
      //   list.length - 1, list.length / 2));
      //   System.out
      //   .println("The Kth (k = 3n/4)" + test.iterativeQuick(list, 0,
      //   list.length - 1, (3 * list.length) / 4));
      //   System.out.println("The Kth (k = n)" + test.iterativeQuick(list, 0,
      //   list.length - 1, list.length));
    
      //   System.out.println("Recursive Quick");
      //   System.out.println("Size" + nSize);
      //   System.out.println("The Kth (k = 1)" + test.recursiveQuick(list, 0,
      //   list.length - 1, 1));
      //   System.out.println("The Kth (k = n/4)" + test.recursiveQuick(list, 0,
      //   list.length - 1, list.length / 4));
      //   System.out.println("The Kth (k = n/2)" + test.recursiveQuick(list, 0,
      //   list.length - 1, list.length / 2));
      //   System.out
      //   .println("The Kth (k = 3n/4)" + test.recursiveQuick(list, 0,
      //   list.length - 1, (3 * list.length) / 4));
      //   System.out.println("The Kth (k = n)" + test.recursiveQuick(list, 0,
      //   list.length - 1, list.length));
  
      //   System.out.println("Median");
      //   System.out.println("Size" + nSize);
    
        
      //   System.out.println("The Kth (k = 1)" + test.medianOfMedians(list, 0,
      //   list.length - 1, 1));
      //   System.out.println("The Kth (k = n/4)" + test.medianOfMedians(list, 0,
      //   list.length - 1, list.length / 4));
      //   System.out.println("The Kth (k = n/2)" + test.medianOfMedians(list, 0,
      //   list.length - 1, list.length / 2));
      //   System.out
      //   .println("The Kth (k = 3n/4)" + test.medianOfMedians(list, 0,
      //   list.length - 1, (3 * list.length) / 4));
      //   System.out.println("The Kth (k = n)" + test.medianOfMedians(list, 0,
      //   list.length - 1, list.length));
