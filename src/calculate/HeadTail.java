package calculate;

import java.util.Arrays;

public class HeadTail {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 6, 6, 8, 10, 20, 50, 50, 100};
        int start = solution(nums, 100, true);
        int end = solution(nums, 100, false);
        System.out.println(start + "," + end);

//        int index = Arrays.binarySearch(nums, 6);
//        System.out.println(index);
    }

    private static int solution(int[] nums, int a, boolean isHead) {
        int head = 0, tail = nums.length - 1;
        do {
            int d = (head + tail) / 2;
            if (nums[d] > a) {
                tail = d - 1;
            } else if (nums[d] < a) {
                head = d + 1;
            } else {
                if (isHead) {
                    if (d == 0 || nums[d - 1] < a) {
                        return d;
                    } else {
                        tail = d - 1;
                    }
                } else {
                    if (d == nums.length - 1 || nums[d + 1] > a) {
                        return d;
                    } else {
                        head = d + 1;
                    }
                }
            }
        } while (head <= tail);

        return -1;
    }

}
