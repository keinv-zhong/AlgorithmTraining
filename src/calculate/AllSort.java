package calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSort {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] nums = {1, 3, 6};

        backtrace(nums, 0, list);

        for (int[] r : list) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static void backtrace(int[] nums, int first, List<int[]> list) {

        if (first == nums.length) {
//            System.out.println(Arrays.toString(nums));
            list.add(nums.clone());
        }

        for (int i = first; i < nums.length; i++) {
            simpleSwap(nums, i, first);
            backtrace(nums, first + 1, list);
            simpleSwap(nums, first, i);
        }
    }

    private static void simpleSwap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
