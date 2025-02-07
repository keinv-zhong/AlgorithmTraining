package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5435, 543, 3, 200, 123};

        System.out.println(Arrays.toString(insertSort(arr)));
    }

    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            //腾出位置插进去,要插的位置是 k + 1;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            //插进去
            arr[j + 1] = temp;
        }
        return arr;
    }
}
