package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {200, 1, 3, 5435, 543, 3, 444, 100};

//        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length-1)));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //获取中轴元素所处的位置
            int mid = partition(arr, left, right);
            //进行分割
            arr = quickSort(arr, left, mid - 1);
            arr = quickSort(arr, mid + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //选取中轴元素
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // 向右找到第一个大于 pivot 的元素位置
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            // 向左找到第一个小于 pivot 的元素位置
            while (i <= j && arr[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        // 使中轴元素处于有序的位置
        arr[j] = pivot;

        System.out.println(Arrays.toString(arr)+"---"+left+"---"+right+"---"+pivot);
        return j;
    }
}