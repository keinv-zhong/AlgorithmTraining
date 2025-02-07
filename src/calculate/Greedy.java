package calculate;

import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 3, 10, 20};
        int[] nums2 = {2, 6, 4, 8, 10, 9, 15};
        int[] nums3 = {2, 4, 8, 10};
        int[] nums4 = {20, 14, 8, 3};
//        System.out.println(shortestArray2(nums));
//        System.out.println(shortestArray2(nums2));
//        System.out.println(shortestArray2(nums4));

        System.out.println(repeatLetter("bcabc"));
    }

    /**
     * 最短无序子数组
     */
    static int shortestArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        Deque<Integer> deque = new LinkedList<>();
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                deque.push(i);
            } else {
                while (deque.size() > 0 && (nums[i] < nums[deque.peek()] || (index > 0 && index < deque.peek()))) {
                    deque.pop();
                }
                index = i;
            }
        }
        System.out.println(deque);

        return nums.length - deque.size();
    }

    /**
     * 最短无序子数组，一次遍历 时间复杂度：O(n) 空间复杂度：O(1)
     * 找出左边界和右边界
     */
    static int shortestArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1, right = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                right = i;
            }

            if (nums[nums.length - 1 - i] < min) {
                min = nums[nums.length - 1 - i];
            } else {
                left = nums.length - 1 - i;
            }
        }

        System.out.println("right:"+right+" left:"+left);
        return right == -1 ? 0 : right - left + 1;
    }

    /**
     * 去除重复字母
     */
    static int repeatLetter(String s) {
//        Deque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i< s.length();i++) {
//            char ch = s.charAt(i);
//            while (stack.size() > 0 && ) {
//
//            }
//            stack.push(ch);
//        }
        return 0;
    }
}
