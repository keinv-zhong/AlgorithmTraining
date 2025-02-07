package calculate;

public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 1, 2, 4, 2, 3};
//        int[] nums = {3, 2, 1, 0, 4};
        int[] nums = {7, 1, 5, 3, 6, 4, 5, 7, 8, 12};
//        System.out.println(stock(nums));

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(gasStation2(gas, cost));
    }

    private static boolean solution(int[] nums) {
        int n = nums.length;
        int mostDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= mostDistance) {
                mostDistance = Math.max(mostDistance, i + nums[i]);
                if (mostDistance >= n - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int solution2(int[] nums) {
        int leastJump = 0;
        int n = nums.length;
        int mostDistance = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= mostDistance) {
                mostDistance = Math.max(mostDistance, i + nums[i]);
                if (i == end) {
                    end = mostDistance;
                    leastJump++;
                }
            }
        }

        if (mostDistance >= n - 1) {
            return leastJump;
        } else {
            return 0;
        }
    }

    private static int stock(int[] nums) {
        int i = 0;
        int j = i + 1;
        int benefit = 0;
        int minSellTimes = 0;
        while (i < nums.length - 1) {
            if (nums[i] < nums[j]) {
                if (j < nums.length - 1 && nums[j + 1] >= nums[j]) {
                    j++;
                } else {
                    benefit += nums[j] - nums[i];
                    minSellTimes++;
                    i = j + 1;
                    j = i + 1;
                }
            } else {
                i = j;
                j = i + 1;
            }
        }
//        return benefit;
        return minSellTimes;
    }

    private static int gasStation(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int gasSum = 0;
            int costSum = 0;
            int k = 1;
            while (k <= gas.length) {
                gasSum += gas[j];
                costSum += cost[j];
                if (gasSum < costSum) {
                     break;
                } else {
                    if (j < gas.length - 1) {
                        j ++;
                    } else if (j == gas.length - 1) {
                        j = 0;
                    }
                    k ++;
                }
            }

            if (k >= gas.length) {
                return i;
            }
        }

        return -1;
    }

    private static int gasStation2(int[] gas, int[] cost) {
        int i = 0;
        while (i < gas.length) {
            int j = i;
            int gasSum = 0;
            int costSum = 0;
            int k = 1;
            while (k <= gas.length) {
                gasSum += gas[j];
                costSum += cost[j];
                if (gasSum < costSum) {
                    i = j + 1;
                    break;
                } else {
                    if (j < gas.length - 1) {
                        j ++;
                    } else if (j == gas.length - 1) {
                        j = 0;
                    }
                    k ++;
                }
            }

            if (k >= gas.length) {
                return i;
            }
        }

        return -1;
    }
}
