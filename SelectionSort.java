import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

class SelectionSort {
    public static void Sort(int[] R) {

      for(int j = R.length-1; j > 0; j--) {
          int max = R[0], maxIndex = 0;
          for(int i = 0; i <= j; i++) {
            if(R[i] > max) {
              max = R[i];
              maxIndex = i;
            }
          }
          //Swap max element and the number at the right
          R[maxIndex] = R[j];
          R[j] = max;
      }
    }

    public static void main(String[] args) throws Exception {
      //int[] Array = {0, 5, 2, 7, 9, 1};

      File file1 = new File(args[0]);
      Scanner sc = new Scanner(file1);

      int intCounter1 = 0;
      while(sc.hasNext()) {
        intCounter1++;
        sc.nextInt();
      }

      sc = new Scanner(file1);

      int[] array1 = new int[intCounter1];

      for(int i = 0; i < intCounter1; i++)
        array1[i] = sc.nextInt();


      Sort(array1);

      for(int i = 0; i < array1.length; i++)
        System.out.println(array1[i]);
    }
}
