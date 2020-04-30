import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

class InsertionSort {

    public String[] sort(String[] array) {
        for (int k = 1; k < array.length; k++) {

            String key = array[k];

            int i = k - 1;

            while (i >= 0 && array[i].compareTo(key) > 0) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        File file =
          new File(args[1]);
        Scanner sc = new Scanner(file);

        int totalNums = Integer.parseInt(args[0]);

        String[] stringsToSort = new String[totalNums];

        for(int i = 0; i < totalNums; i++)
          stringsToSort[i] = sc.nextLine();

        InsertionSort sort = new InsertionSort();
        sort.sort(stringsToSort);

        for(int i = 0; i < totalNums; i++)
          System.out.println(stringsToSort[i]);
    }
}
