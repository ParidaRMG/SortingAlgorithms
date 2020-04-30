import java.util.Scanner;
import java.io.File;

public class BubleSort {

  public static void main(String[] args) throws Exception {

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

      BubbleSort(array1);

      for(int i = 0; i < array1.length-1; i++)
        System.out.print(array1[i] + " ");
      System.out.print(array1[array1.length-1]); //Formatted this way for Submitty
    }

  public static void BubbleSort(int[] array1) {
    int bound = array1.length - 1;

    while(true) {

      int t = 0;

      for(int j = 0; j < bound; j++) {

        if(array1[j] > array1[j+1]) {
          int temp = array1[j];
          array1[j] = array1[j + 1];
          array1[j + 1] = temp;

          t = j;
        }
      }

      if (t == 0)
        return;
      bound = t;
    }
  }

}
