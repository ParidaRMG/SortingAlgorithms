import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

class DistributionCountingSort {

  public static void main(String[] args) throws Exception {

    File files = new File(args[1]);
    Scanner sc = new Scanner(files);

    int[] unsortedArray = new int[Integer.parseInt(args[0])];

    for(int i = 0; i < Integer.parseInt(args[0]); i++) {
      unsortedArray[i] = sc.nextInt();
    }

    int min = Integer.parseInt(args[2]);
    int max = Integer.parseInt(args[3]);

    //System.out.println("Unsorted array: \n" + Arrays.toString(unsortedArray));

    int[] sortedArray = DistributionSort(min, max, unsortedArray);

    //System.out.println("Sorted array: \n" + Arrays.toString(sortedArray));

    for(int i = 0; i < sortedArray.length; i++) {
      System.out.println(sortedArray[i]);
    }

  }

  static int[] DistributionSort(int min, int max, int[] unsorted) {

    int[] COUNT = new int[max];
    for(int i = 0; i < COUNT.length; i++){
      COUNT[i] = 0;
    }

    for(int j = 0; j < unsorted.length; j++) {
      COUNT[unsorted[j]]++;
    }

    for(int i = 1; i < COUNT.length; i++){
      COUNT[i] += COUNT[i-1];
    }

    int[] S = new int[unsorted.length];
    for(int k = 0; k < S.length; k++){
      S[k] = 0;
    }

    for(int j = unsorted.length-1; j >= 0; j--) {

      int i = COUNT[unsorted[j]];

      S[i-1] = unsorted[j];
      //COUNT[unsorted[j-1]] = i-1;
      COUNT[unsorted[j]]--;
    }

    return S;

  }

}
