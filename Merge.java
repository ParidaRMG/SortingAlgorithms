import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Merge{
  public static void main(String [] args) throws FileNotFoundException {


    File file1 = new File(args[0]);
    Scanner sc = new Scanner(file1);

    //Array 1
    int intCounter1 = 0;
    while(sc.hasNext()) {
      intCounter1++;
      sc.nextInt();
    }

    sc = new Scanner(file1);

    int[] array1 = new int[intCounter1];

    for(int i = 0; i < intCounter1; i++)
      array1[i] = sc.nextInt();

    //Array 2

    file1 = new File(args[1]);
    sc = new Scanner(file1);

    int intCounter2 = 0;
    while(sc.hasNext()) {
      intCounter2++;
      sc.nextInt();
    }

    sc = new Scanner(file1);

    int[] array2 = new int[intCounter2];

    for(int i = 0; i < intCounter2; i++)
      array2[i] = sc.nextInt();

    InsertionSort(array1);
    ReverseSort(array2);

    int mergedLength = array1.length + array2.length-1;

    for(int i = 0; i < array1.length-1; i++)
      System.out.print(array1[i] + " ");
    System.out.print(array1[array1.length-1]);

    System.out.println();

    for(int i = 0; i < array2.length - 1; i++)
      System.out.print(array2[i] + " ");
    System.out.print(array2[array2.length-1]);

    System.out.println();

    InsertionSort(array2);

    int [] mergedAry = mergeSort(array1, array2);

    for(int i = 0; i < mergedAry.length - 1; i++)
      System.out.print(mergedAry[i] + " ");
    System.out.print(mergedAry[mergedAry.length-1]);


  }

  public static void InsertionSort(int[] ary){

    for(int j=1; j<ary.length; j++){

      int key = ary[j];

      int i  = j-1;

      while(i>=0 && ary[i]>key){

        ary[i+1] = ary[i];
        i--;
      }
      ary[i+1]=key;
    }
  }

  public static void ReverseSort(int[] ary){

    for (int i = 1; i < ary.length; i++) {

          int key = ary[i];
          int j = i;

          while (j > 0 && ary[j - 1] < key) {
              ary[j] = ary[j - 1];
              j--;
          }
          ary[j] = key;
      }
  }

  public static int[] mergeSort(int[] ary1, int[] ary2) {

    int merged [] = new int[ary1.length + ary2.length];

    int d = ary2.length - 1;

    int a = ary1.length - 1;

    for(int q = 0; q < merged.length; q++) {

      if (d > -1 && a > -1 ) {
        if (ary2[d] > ary1[a]) {
          merged[q] = ary2[d];
          d--;
        }

        else {
          merged[q] = ary1[a];
          a--;
        }
      }

      else if (d <= -1) {
        while (a > -1) {
          merged[q] = ary1[a];
          a--;
          q++;
        }
      }

      else {
        while (d > -1) {
          merged[q] = ary2[d];
          d--;
          q++;
        }
      }
    }

    return merged;
    }

}
