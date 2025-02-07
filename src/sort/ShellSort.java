package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {899, 1, 3, 200, 23, 90, 543, 3, 2};

        System.out.println(Arrays.toString(shellSort(arr)));
    }

    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            //对各个局部分组进行插入排序
            for (int i = gap; i < n; i++) {
                // 将arr[i] 插入到所在分组的正确位置上
                insertI(arr, gap, i);
            }
        }
        return arr;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上
     * arr[i]] 所在的分组为 ... arr[i-2*h],arr[i-h], arr[i+h] ...
     */
    private static void insertI(int[] arr, int gap, int i) {
        int temp = arr[i];
        int k;
        for (k = i - gap; k >= 0 && temp < arr[k]; k -= gap) {
            arr[k + gap] = arr[k];
        }
        arr[k + gap] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
