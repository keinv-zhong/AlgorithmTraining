package calculate;

import java.util.*;

public class DynamicPlanning {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 1, 2, 4, 2, 3};

        // 最长递增子序列
        int[] nums = {7, 1, 5, 3, 6, 4, 5, 7, 8, 12};
//        System.out.println(maxIncreaseSubSeq(nums));
//        System.out.println(maxIncreaseSubSeqBinarySearch(nums));

        // 最长有效括号
//        String s = "((()))())(";
//        String s = "((()(";
//        System.out.println(maxValidBracketLength(s));
//        System.out.println(maxValidBracketLength2(s));

        // 接雨水
        int[] nums2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums3 = {4, 2, 0, 3, 2, 5};
//        System.out.println(rainwater3(nums));
//        System.out.println(rainwater3(nums2));
//        System.out.println(rainwater3(nums3));
//
//        System.out.println(rainwater4(nums));
//        System.out.println(rainwater4(nums2));
//        System.out.println(rainwater4(nums3));

        // 不同路径
//        System.out.println(differentRoute(3, 2));
//        System.out.println(differentRoute(3, 7));

//        System.out.println(differentRoute2(3, 2));
//        System.out.println(differentRoute2(3, 7));

        int[][] gridParam = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        System.out.println(differentRouteTwo(gridParam));


//        System.out.println(climbStairs(2));
//        System.out.println(climbStairs(3));
//        System.out.println(climbStairs(4));

        // 最大矩阵面积
        int[][] gridParam2 = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
//        System.out.println(maxMatrix(gridParam));
//        System.out.println(maxMatrix(gridParam2));

        // 二叉搜索树

        // 买卖股票
        int[] nums4 = {7, 1, 5, 3, 6, 4};
        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {3, 3, 5, 0, 0, 3, 1, 8};
//        System.out.println(buyStock(nums4));
//        System.out.println(buyStock2(nums4));
//        System.out.println(buyStock2(nums5));
//        System.out.println(buyStock3(nums4));
//        System.out.println(buyStock3(nums5));
//        System.out.println(buyStock3(nums6));

//        System.out.println(buyStock4(nums4, 4));
//        System.out.println(buyStock4(nums5, 3));
//        System.out.println(buyStock4(nums6, 2));

        int[] nums10 = {1, 2, 5};
//        System.out.println(looseChange(nums10, 11));
//        System.out.println(looseChange(nums10, 1));

        int[][] gridParam3 = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
//        System.out.println(triangle(gridParam3));

        System.out.println(palindromic("aab"));
        System.out.println(palindromic("aaba"));
        System.out.println(palindromic("aabaa"));
    }

    static int maxValidBracketLength(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i > 2) {
                        dp[i] = dp[i - 2] + 2;
                        maxLength = Math.max(maxLength, dp[i]);
                    } else {
                        dp[i] = 2;
                        maxLength = 2;
                    }
                } else if (dp[i - 1] > 0) {
                    if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        maxLength = Math.max(maxLength, dp[i]);
                    }
                }
            }
        }

        return maxLength;
    }

    static int maxValidBracketLength2(String s) {
        int maxLength = 0, leftNum = 0, rightNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftNum++;
            } else if (s.charAt(i) == ')') {
                if (leftNum <= rightNum) {
                    maxLength = Math.max(maxLength, 2 * rightNum);
                    leftNum = 0;
                    rightNum = 0;
                } else {
                    rightNum++;
                }
            }
        }

        maxLength = Math.max(maxLength, 2 * Math.min(leftNum, rightNum));

        return maxLength;
    }

    /**
     * two pointers
     */
    static int rainwater(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int sumRainwater = 0;
        int left = 0, right = left + 1;
        int maxRightNum = 0;
        int maxRightIndex = 0;
        while (right < nums.length) {
            if (nums[right] >= nums[left]) {
                left = right;
                right = left + 1;
                maxRightIndex = right;
            } else {
                sumRainwater += nums[left] - nums[right];
                if (nums[right] >= maxRightNum) {
                    maxRightNum = nums[right];
                    maxRightIndex = right;
                }
                if (right == nums.length - 1) {
                    sumRainwater -= (nums[left] - maxRightNum) * (right - left);
                }
                right++;
            }
        }

        // 补偿没有右边界的多加数据
        if (maxRightIndex < nums.length - 1) {
            for (int i = maxRightIndex + 1; i <= nums.length - 1; i++) {
                sumRainwater -= maxRightNum - nums[i];
            }
        }

        return sumRainwater;
    }

    /**
     * two pointers2 更优
     */
    static int rainwater2(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int sumRainwater = 0;
        int left = 0, right = nums.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, nums[left]);
            rightMax = Math.max(rightMax, nums[right]);
            if (nums[left] < nums[right]) {
                sumRainwater += leftMax - nums[left];
                left++;
            } else {
                sumRainwater += rightMax - nums[right];
                right--;
            }
        }

        return sumRainwater;
    }

    /**
     * dynamic planning
     */
    static int rainwater3(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMax[0] = nums[0];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int sumRainwater = 0;
        for (int i = 0; i < nums.length; i++) {
            sumRainwater += Math.min(leftMax[i], rightMax[i]) - nums[i];
        }

        return sumRainwater;
    }

    /**
     * Monotone stack
     */
    static int rainwater4(int[] nums) {
        int sumRainwater = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() >= 2 && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                sumRainwater += (Math.min(nums[i], nums[stack.peek()]) - nums[top]) * (i - stack.peek() - 1);
            }

            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            } else {
                stack.pop();
                stack.push(i);
            }
        }

        return sumRainwater;
    }

    static int maxIncreaseSubSeq(int[] nums) {
        int maxLength = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * dynamic planning | binary search | greed
     */
    static int maxIncreaseSubSeqBinarySearch(int[] nums) {
        int maxLength = 1;
        int[] d = new int[nums.length];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[i - 1]) {
                maxLength++;
                d[i] = nums[i];
            } else {
                int begin = 0, end = maxLength, j;
                do {
                    j = (begin + end) / 2;
                    if (nums[i] <= d[j]) {
                        if (j == 0 || nums[i] > d[j - 1]) {
                            d[j] = nums[i];
                            break;
                        } else {
                            end = j - 1;
                        }
                    } else {
                        begin = j + 1;
                    }
                } while (j > 0 && j < maxLength);
            }
        }

        return maxLength;
    }

    static int differentRoute(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] += (i > 0 ? grid[i - 1][j] : 0) + (j > 0 ? grid[i][j - 1] : 0);
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * 时间复杂度O(n)
     * 只保存上一行数据，一边遍历一边更新到当前行
     */
    public static int differentRoute2(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[j] += f[j - 1];
            }
        }
        return f[n - 1];
    }

    /**
     * 不同路径二
     */
    public static int differentRouteTwo(int[][] gridParam) {
//        int[][] grid = new int[gridParam.length][gridParam[0].length];
        int[] f = new int[gridParam[0].length];
        Arrays.fill(f, 1);
//        grid[0][0] = 1;
        for (int i = 1; i < gridParam.length; i++) {
            for (int j = 1; j < gridParam[0].length; j++) {
                if (gridParam[i][j] == 0) {
//                    grid[i][j] += (i > 0 ? grid[i - 1][j] : 0) + (j > 0 ? grid[i][j - 1] : 0);
                    f[j] += f[j - 1];
                } else {
//                    grid[i][j] = 0;
                    f[j] = 0;
                }

            }
        }

//        return grid[gridParam.length - 1][gridParam[0].length - 1];
        return f[gridParam[0].length - 1];
    }

    /**
     * 爬楼梯，每次1或2层
     */
    public static int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /**
     * 最大矩阵面积 m*m*n
     */
    static int maxMatrix(int[][] gridParam) {
        int maxAcreage = 0;
        int[][] across = new int[gridParam.length][gridParam[0].length];
        for (int i = 0; i < gridParam.length; i++) {
            for (int j = 0; j < gridParam.length; j++) {
                if (gridParam[i][j] == 1) {
                    across[i][j] = j == 0 ? 1 : across[i][j - 1] + 1;
                }
            }
        }

        return maxAcreage;
    }

    /**
     * 二叉搜索树
     */
//    static int tree2(int n) {
//        int count = 0;
//        Node root = new Node();
//        for (int i = 1; i <= n; i++) {
//            root.setValue(i);
//            for (int j = 1; j <= n; j++) {
//
//            }
//        }
//
//        return count;
//    }

    /**
     * 买卖股票最佳时机 O(n) O(1)
     */
    static int buyStock(int[] nums) {
        int money = 0;
        int minBuy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minBuy) {
                minBuy = nums[i];
            } else {
                money = Math.max(money, nums[i] - minBuy);
            }

        }

        return money;
    }

    /**
     * 买卖股票最佳时机2 O(n) O(1)
     */
    static int buyStock2(int[] nums) {
        int money = 0;
        int minBuy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minBuy) {
                minBuy = nums[i];
            } else {
                money += nums[i] - minBuy;
                minBuy = nums[i];
            }

        }

        return money;
    }

    /**
     * 买卖股票最佳时机3 O(n) O(1)
     */
    static int buyStock3(int[] nums) {
        int money1 = 0;
        int money2 = 0;
        int minBuy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minBuy) {
                minBuy = nums[i];
            } else {
                if (i < nums.length - 1 && nums[i + 1] >= nums[i]) {
                    continue;
                } else {
                    if (nums[i] - minBuy > money1) {
                        money2 = money1;
                        money1 = nums[i] - minBuy;
                    } else if (nums[i] - minBuy > money2) {
                        money2 = nums[i] - minBuy;
                    }
                    minBuy = nums[i];
                }
            }

        }

        return money1 + money2;
    }

    /**
     * 买卖股票最佳时机4 O(n) O(1)
     */
    static int buyStock4(int[] nums, int k) {
        List<Integer> money = new ArrayList<>(k);
        int minBuy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minBuy) {
                minBuy = nums[i];
            } else {
                if (i < nums.length - 1 && nums[i + 1] >= nums[i]) {
                    continue;
                } else {
                    money.add(nums[i] - minBuy);
                    minBuy = nums[i];
                }
            }
        }

        if (money.size() > k) {
            Arrays.sort(money.toArray());
            money = money.subList(money.size() - k, money.size());
            System.out.println(money);
        }
        return money.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 零钱兑换
     */
    static int looseChange(int[] nums, int amount) {
        int number = 0;
        int index = nums.length - 1;
        while (amount > 0 && index >= 0) {
            if (amount >= nums[index]) {
                number += amount / nums[index];
                amount -= (amount / nums[index]) * nums[index];
            }
            index--;
        }

        if (amount == 0) {
            return number;
        } else {
            return -1;
        }
    }

    /**
     * 三角形最小路径和
     */
    static int triangle(int[][] gridParam) {
        int minPath = Integer.MAX_VALUE;
        int[] row = new int[gridParam.length];
        row[0] = gridParam[0][0];
        for (int i = 1; i < gridParam.length; i++) {
//            System.out.println(Arrays.toString(row)+ " " +gridParam[i].length);
            for (int j = gridParam[i].length - 1; j >= 0; j--) {
                if (j == 0) {
                    row[j] = row[j] + gridParam[i][j];
                } else if (j == gridParam[i].length - 1) {
                    row[j] = row[j - 1] + gridParam[i][j];
                } else {
                    row[j] = Math.min(row[j - 1], row[j]) + gridParam[i][j];
                }
                if (i == gridParam.length - 1) {
                    minPath = Math.min(row[j], minPath);
                }
            }
            System.out.println(Arrays.toString(row) + " " + gridParam[i].length);
        }

        return minPath;
    }

    /**
     * 回文串
     */
    static List<List<String>> palindromic(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> singleResult = new ArrayList<>();
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(f[i], true);
//            f[i][i] = true;
        }
//        for (boolean[] a : f) {
//            System.out.println(Arrays.toString(a));
//        }

        // 回文串计算 动态规划
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
//        for (boolean[] a : f) {
//            System.out.println(Arrays.toString(a));
//        }

        palindromic0(s, 0, 1, result, singleResult, f);
        return result;
    }

    static void palindromic0(String s, int beginIndex, int endIndex, List<List<String>> result, List<String> singleResult, boolean[][] f) {
//        System.out.println("beginIndex:"+beginIndex+" endIndex:"+endIndex+" singleResult:"+singleResult);
        if (endIndex == s.length() + 1) {
            result.add(new ArrayList<>(singleResult));
            return;
        }

        for (int i = endIndex; i <= s.length(); i++) {
            if (!f[beginIndex][i-1]) {
                continue;
            }

            singleResult.add(s.substring(beginIndex, i));
            palindromic0(s, i, i + 1, result, singleResult, f);
            singleResult.remove(singleResult.size() - 1);
        }
    }

}
