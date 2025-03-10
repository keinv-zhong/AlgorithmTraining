package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingArray {

    /**
     * 88合并两个有序数组
     */
    static int[] mergeTwoSeqArray(int[] nums1, int[] nums2) {
        // 此处使用了临时变量nums0；使用逆向双指针可去除临时变量，nums1后面部分为0可直接填充
        int[] nums0 = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums0[k] = nums1[i];
                k++;
                i++;
            } else {
                nums0[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (i == nums1.length) {
            System.arraycopy(nums2, j, nums0, i + j, nums2.length - j);
        }
        if (j == nums2.length) {
            System.arraycopy(nums1, i, nums0, i + j, nums1.length - i);
        }

        return nums0;
    }

    /**
     * 27移除数组中某个元素
     */
    static int[] removeNum(int[] nums, int number) {
        int i = 0, j = nums.length - 1;
        boolean reverse = false;
        while (i < j) {
            if (!reverse) {
                if (nums[i] == number) {
                    reverse = true;
                } else {
                    i++;
                }
            } else {
                if (nums[j] == number) {
                    j--;
                } else {
                    nums[i] = nums[j];
                    reverse = false;
                    j--;
                    i++;
                }
            }
        }

        if (nums[i] == number) {
            System.out.println(i);
        } else {
            System.out.println(i + 1);
        }

        return nums;
    }

    /**
     * 26删除数组中的重复元素
     */
    static int[] removeDuplicateNum(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }

        System.out.println(index + 1);

        return nums;
    }

    /**
     * 80删除数组中的重复元素2，最多出现2次
     */
    static int[] removeDuplicateNum2(int[] nums) {
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
                count = 1;
            } else if (count == 1) {
                index++;
                count++;
            }
        }

        System.out.println(index + 1);

        return nums;
    }

    /**
     * 189轮转数组
     */
    static int[] moveArray(int[] nums, int k) {
        int index = 0, remainder = 0, temp = nums[0];
        while (remainder < k) {
            if (index + k <= nums.length - 1) {
                nums[index + k] = temp;
                temp = nums[index];
                index = index + k;
            } else {
                remainder++;
                index = remainder;
                temp = nums[index];
//                nums[index + k - nums.length + 1] = temp;
//                temp = nums[index];
//                index = index + k - nums.length + 1;
//                if ((index + k - nums.length + 1) % k == remainder) {
//                    nums[index + k - nums.length + 1] = temp;
//                    index ++;
//                    remainder = index % k;
//                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 8};
//        int[] nums2 = {2, 5, 6};
//        int[] nums3 = {5, 7, 9, 18};
//        int[] nums4 = {2, 3, 8};
//        int[] result = mergeTwoSeqArray(nums1, nums2);
//        int[] result2 = mergeTwoSeqArray(nums3, nums4);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(result2));

//        int[] nums1 = {1, 2, 3, 8, 0,0,0};
//        int[] nums2 = {2, 5, 6};
//        int[] nums3 = {5, 7, 9, 18,0,0,0};
//        int[] nums4 = {2, 3, 8};
//        int[] result = mergeTwoSeqArray(nums1, nums2);
//        int[] result2 = mergeTwoSeqArray(nums3, nums4);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(result2));

//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
////        int[] nums = {0, 1, 2, 2, 2, 2, 3, 0, 4, 2};
//        int[] result = removeNum(nums, 2);
//        System.out.println(Arrays.toString(result));
//        int[] nums2 = {3, 2, 2, 3};
//        int[] result2 = removeNum(nums2, 3);
//        System.out.println(Arrays.toString(result2));

//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 4, 4};
//        int[] result = removeDuplicateNum2(nums);
//        System.out.println(Arrays.toString(result));

        int[] nums = {5, 7, 9, 18};
        int[] result = moveArray(nums, 2);
        System.out.println(Arrays.toString(result));
    }

}