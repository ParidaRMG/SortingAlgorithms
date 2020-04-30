//Dual pivot quick sort for submission

import java.util.Scanner;
import java.io.File;

public class DualPivotQuickSort {

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

        DualPivotQuickSort(array1, 0, array1.length -1);

        for(int i = 0; i < array1.length-1; i++)
          System.out.print(array1[i] + " ");
        System.out.print(array1[array1.length-1]); //Formatted this way for Submitty
    }

    public static void DualPivotQuickSort(int[] A, int left, int right) {
      int temp;
      int p, q, l, g, k;

      if(right-left >= 1) {
        p = A[left];
        q = A[right];

        if(p < q) {
          temp = q;
          q = p;
          p = temp;

          temp = A[left];
          A[left] = A[right];
          A[right] = temp;
        }

        l = left + 1;
        g = right - 1;
        k = l;

        while(k <= g) {

          if(A[k] > p){
            temp = A[k];
            A[k] = A[l];
            A[l] = temp;

            l = l + 1;
          }
          else {
            if(A[k] < q) {

              while(A[g] < q && k < g)
                g = g - 1;

              temp = A[k];
              A[k] = A[g];
              A[g] = temp;

              g = g - 1;

              if(A[k] > p) {
                temp = A[k];
                A[k] = A[l];
                A[l]=temp;

                l = l + 1;
              }
            }
          }
          k = k + 1;
        }
        l = l - 1;
        g = g + 1;

        temp = A[left];
        A[left] = A[l];
        A[l] = temp;

        temp = A[right];
        A[right] = A[g];
        A[g] = temp;

        DualPivotQuickSort(A, left, l-1);
        DualPivotQuickSort(A, l+1, g-1);
        DualPivotQuickSort(A, g+1, right);

      }
    }

}
