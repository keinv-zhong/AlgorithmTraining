package calculate;

public class MaxVolume {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int start = solution(nums);
        System.out.println(start);
    }

    private static int solution(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int volume = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            volume = Math.max(volume, (j - i) * Math.min(nums[i], nums[j]));
            if (nums[i] < nums[j]) {
                i++;
            } else {
                j --;
            }
        }

        return volume;
    }

}
