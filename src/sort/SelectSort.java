package sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {200, 1, 3, 5435, 543, 3, 444, 100};

        System.out.println(Arrays.toString(selectSort(arr)));
    }

    public static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            //交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}
