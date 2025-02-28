package calculate;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        int[] m = {1, 3, 6, 543, 3000};
        int[] n = {1, 3, 15, 56, 300};

        System.out.println(merge(m, n));

        System.out.println(findMedianSortedArrays(m, n));
    }

    public static float merge(int[] m, int[] n) {
        int[] arr = new int[m.length + n.length];

        int i = 0, j = 0, k = 0;
        while (i <= m.length - 1 && j <= n.length - 1) {
            if (m[i] <= n[j]) {
                arr[k++] = m[i++];
            } else {
                arr[k++] = n[j++];
            }
        }
        while (i <= m.length - 1) {
            arr[k++] = m[i++];
        }
        while (j <= n.length - 1) {
            arr[k++] = n[j++];
        }

        float media;
        int medianIndex = arr.length / 2;
        if (arr.length % 2 > 0) {
            media = arr[medianIndex];
        } else {
            media = ((float) (arr[medianIndex] + arr[medianIndex - 1])) / 2;
        }

        System.out.println(Arrays.toString(arr));
        return media;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
}
