package calculate;

import java.util.*;

public class MaxSubList {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 12, 11, 6, 50, 86, 43, 44, 45, 46, 47};
//        int[] arr = new int[]{10, 6, 4, 40};
//        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }

    public static int solution(int[] nums) {
        int maxLength = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * 时间复杂度O(n*log(n)) 空间复杂度O(n)
     * 二分查找，保存最小值子串到List
     */
    public static int solution2(int[] nums) {
        List<Integer> subIncreaseList = new ArrayList<>(nums.length);
        subIncreaseList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int insert = 0, begin = 0, end = subIncreaseList.size();
            while (begin <= end) {
                insert = (begin + end) >>> 1;
//                System.out.println("begin:"+begin+" end:"+end+ " insert:"+insert);
                if (insert > subIncreaseList.size() - 1) {
                    break;
                }

                if (nums[i] > subIncreaseList.get(insert)) {
                    begin = insert + 1;
                } else {
                    if (insert == 0 || subIncreaseList.get(insert - 1) < subIncreaseList.get(insert)) {
                        break;
                    }
                    end = insert - 1;
                }
            }
            System.out.println("insert:"+insert+" nums[i]："+nums[i]+" subIncreaseList:"+subIncreaseList);
            if (insert >= subIncreaseList.size()) {
                subIncreaseList.add(insert, nums[i]);
            } else {
                subIncreaseList.set(insert, nums[i]);
            }
        }

        return subIncreaseList.size();
    }
}
