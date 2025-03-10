package training;

import java.util.Arrays;

public class DynamicPlanningTrain {

    /**
     * 70爬楼梯
     */
    static int climbFloor(int n) {
//        int[] result = new int[n + 1];
//        result[0] = 1;
//        result[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            result[i] = result[i-1] + result[i-2];
//        }
//
//        return result[n];

        int before1 = 1;
        int before2 = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = before1 + before2;
            before1 = before2;
            before2 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 18};
//        int[] result = moveArray(nums, 2);
        System.out.println(climbFloor(2));
        System.out.println(climbFloor(3));
        System.out.println(climbFloor(4));
        System.out.println(climbFloor(5));

    }

}