package calculate;

import java.util.Arrays;

public class MinSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 7, 1, 4, 9, 3};

        System.out.println(solution(nums, 8));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 滑动窗口O(n) 二分查找 时间复杂度(n*log(n))
     * */
    private static int solution(int[] nums, int x) {
//        Arrays.binarySearch(nums, x);
        int start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= x) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start ++;
            }
            end ++;
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }

    /**
     * 常规解法 时间复杂度O(n^2)，空间复杂度1
     * */
    private static int solution0(int[] nums, int x) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                if (count >= x) {
                    if ((j - i + 1) < length) {
                        length = j - i + 1;
                    }
                    break;
                }
            }
        }

        if (length == Integer.MAX_VALUE) {
            length = 0;
        }

        return length;
    }
}
