import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] nums2 = {2, 1, 1, 1, 1, 5, 6, 2, 3};
        int[] nums3 = {2, 1, 1, 1, 1, 1, 1, 5, 6, 3, 3};
        int[] nums4 = {2, 2, 2, 5, 6, 4, 4};
//        System.out.println(maxRectangle(nums));
//        System.out.println(maxRectangle(nums2));
//        System.out.println(maxRectangle(nums3));
//        System.out.println(maxRectangle(nums4));

        Arrays.binarySearch(nums, 5);

        List<int[]> intervals = Arrays.asList(new int[]{1, 3}, new int[]{6, 9});
        int[] insert = new int[]{2, 5};

        List<int[]> intervals2 = Arrays.asList(new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16});
        int[] insert2 = new int[]{4, 8};
//        List<int[]> result = insertInterval(intervals, insert);
        List<int[]> result = insertInterval(intervals2, insert2);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }

    }

    /**
     * 最大矩形
     */
    static int maxRectangle(int[] nums) {
        int maxArea = 0;
        for (int i = 1; i < nums.length; i++) {
            int minHeight = nums[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, nums[j]);
                int area = minHeight * (i - j + 1);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    /**
     * 插入区间
     */
    static List<int[]> insertInterval(List<int[]> intervals, int[] insert) {
        List<int[]> result = new ArrayList<>(intervals.size() + 1);

        // O(n)
        boolean flag = false;
        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (flag) {
                result.add(interval);
            }

            if (insert[0] > interval[1]) {
                result.add(interval);
            } else if (insert[1] < interval[0]) {
                flag = true;
                result.add(insert);
                result.add(interval);
            } else {
                insert = new int[]{Math.min(insert[0], interval[0]), Math.max(insert[1], interval[1])};
                if (i == intervals.size() - 1) {
                    result.add(insert);
                }
            }
        }
        return result;
    }

    /**
     * 插入区间
     */
//    static List<LinkedList<Integer>> insertInterval(List<Node<Integer>> list) {
//
//
//        return null;
//    }
//
//    static List<LinkedList<Integer>> megerLinkedList(List<LinkedList<Integer>> left, List<LinkedList<Integer>> right) {
//
//    }
}