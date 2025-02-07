package calculate;

import java.util.*;

public class backtrack {
    public static void main(String[] args) {
//        System.out.println(phoneNumber("2"));
//        System.out.println(phoneNumber("23"));
//        System.out.println(phoneNumber("239"));

        // 生成括号
//        System.out.println(bracketGenerate(1));
//        System.out.println(bracketGenerate(3));
//        System.out.println(bracketGenerate(4));

//        int[] nums = {1, 2, 3};
//        List<int[]> result = allSortTwo(nums);
//        for (int[] r : result) {
//            System.out.println(Arrays.toString(r));
//        }

//        List<List<int[]>> result = nQueen(4);
//        for (List<int[]> r : result) {
//            for (int[] s : r) {
//                System.out.print(Arrays.toString(s));
//            }
//            System.out.println();
//        }

//        int[] nums = {3, 2, 4};
//        int[] nums = {2, 2, 1};
//        int[] nums = {10, 1, 2, 7, 6, 1, 5};
//        int[] nums = {3, 2, 4, 5};
        int target = 8;
//        System.out.println(combinationSum(nums, target));

//        int[] nums2 = {10, 1, 2, 7, 6, 1, 5};
//        int target2 = 8;
        int[] nums2 = {2, 5, 2, 1, 2};
        int target2 = 5;
//        System.out.println(combinationSum2(nums2, target2));

//        System.out.println(subArray(nums));
//        System.out.println(subArray2(nums));

        int[] nums = {2, 2, 1, 1, 1, 1 ,3,3,3,3};
        System.out.println(matchsticks(nums));

    }

    /**
     * 电话号码的字母组合
     */
    static List<String> phoneNumber(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Character>> numberMap = new HashMap<>();
        numberMap.put('2', Arrays.asList('a', 'b', 'c'));
        numberMap.put('3', Arrays.asList('d', 'e', 'f'));
        numberMap.put('4', Arrays.asList('g', 'h', 'i'));
        numberMap.put('5', Arrays.asList('j', 'k', 'l'));
        numberMap.put('6', Arrays.asList('m', 'n', 'o'));
        numberMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        numberMap.put('8', Arrays.asList('t', 'u', 'v'));
        numberMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        char[] ch = digits.toCharArray();
        if (0 == ch.length) {
            return result;
        }
        char[] res = new char[ch.length];
        int i = 0;
        phoneNumber0(numberMap, ch, i, res, result);

        return result;
    }

    static void phoneNumber0(Map<Character, List<Character>> numberMap, char[] ch, int i, char[] res, List<String> result) {
        if (i == res.length) {
            result.add(Arrays.toString(res));
            return;
        }

        List<Character> characters = numberMap.get(ch[i]);
        if (null != characters && !characters.isEmpty()) {
            for (Character character : characters) {
                res[i] = character;
                i++;
                phoneNumber0(numberMap, ch, i, res, result);
                i--;
            }
        }
    }

    static List<String> bracketGenerate(int n) {
        List<String> resultList = new ArrayList<>();
        char[] brackets = new char[2 * n];

        int i = 0;
        // 保存位置i前的左括号数量
        int[] leftBracketNum = new int[2 * n];
        Arrays.fill(leftBracketNum, 0);
//        char[] bracketTwo = {'(',')'};
//        bracketGenerate0(i, brackets, resultList, leftBracketNum);

        StringBuilder bracketsSb = new StringBuilder(2 * n);
        bracketGenerate00(bracketsSb, resultList, 0, 0, n);
        return resultList;
    }

    static void bracketGenerate0(int i, char[] brackets, List<String> resultList, int[] leftBracketNum) {
//        System.out.println(i+ "-"+Arrays.toString(brackets));
//        System.out.println(Arrays.toString(leftBracketNum));
        if (i == brackets.length) {
            resultList.add(Arrays.toString(brackets));
            return;
        }

        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                if (leftBracketNum[i] < brackets.length / 2) {
                    if (brackets[i] != '(') {
                        for (int k = i + 1; k < brackets.length; k++) {
                            leftBracketNum[k]++;
                        }
                    }

                    brackets[i] = '(';
                    i++;
                    bracketGenerate0(i, brackets, resultList, leftBracketNum);
                    i--;
                }
            } else {
                if (i - leftBracketNum[i] < leftBracketNum[i]) {
                    if ('(' == brackets[i]) {
                        for (int k = i + 1; k < brackets.length; k++) {
                            leftBracketNum[k]--;
                        }
                    }

                    brackets[i] = ')';
                    i++;
                    bracketGenerate0(i, brackets, resultList, leftBracketNum);
                    i--;
                }
            }
        }
    }

    static void bracketGenerate00(StringBuilder brackets, List<String> resultList, int open, int close, int n) {
        System.out.println("open:" + open + " close:" + close + " brackets:" + brackets.toString());
        if (brackets.length() == n * 2) {
            resultList.add(brackets.toString());
            return;
        }

        if (open < n) {
            brackets.append('(');
            bracketGenerate00(brackets, resultList, open + 1, close, n);
            brackets.deleteCharAt(brackets.length() - 1);
        }
        if (close < open) {
            brackets.append(')');
            bracketGenerate00(brackets, resultList, open, close + 1, n);
            brackets.deleteCharAt(brackets.length() - 1);
        }
    }

    /**
     * 全排列2
     */
    static List<int[]> allSortTwo(int[] nums) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        boolean[] vis = new boolean[nums.length];
        int[] temp = new int[nums.length];
        Arrays.sort(nums);
        allSortTwo0(nums, i, result, vis, temp);

        // 不使用额外空间
//        allSortTwo00(nums, i, result);

        // 去重
        List<int[]> result2 = new ArrayList<>(result.size());
        for (int[] t : result) {
            boolean containFlag = false;
            for (int[] t2 : result2) {
                if (arrayCompare(t, t2)) {
                    containFlag = true;
                }
            }
            if (!containFlag) {
                result2.add(t);
            }
        }

        return result;
    }

    static void allSortTwo0(int[] nums, int i, List<int[]> result, boolean[] vis, int[] temp) {
        System.out.println(i + "-" + Arrays.toString(temp) + "-" + Arrays.toString(vis));
        if (i == nums.length) {
            result.add(Arrays.copyOf(temp, temp.length));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (vis[j] || (i > 0 && nums[i] == nums[i - 1]) && !vis[i - 1]) {
                continue;
            }
//            if (vis[j]) {
//                continue;
//            }

            temp[i] = nums[j];
            vis[j] = true;
            allSortTwo0(nums, i + 1, result, vis, temp);
            vis[j] = false;
        }
    }

    static void allSortTwo00(int[] nums, int i, List<int[]> result) {
        if (i == nums.length) {
            result.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            allSortTwo00(nums, i + 1, result);
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static boolean arrayCompare(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * N皇后
     */
    static List<List<int[]>> nQueen(int n) {
        List<List<int[]>> result = new ArrayList<>();
        // Q的位置坐标
        List<int[]> singleResult = new ArrayList<>(n);
        // 需要排除的坐标
        List<int[]> vis = new ArrayList<>();
        // 行坐标
        int i = 0;
        nQueen0(n, singleResult, i, result, vis);

        return result;
    }

    static void nQueen0(int n, List<int[]> singleResult, int i, List<List<int[]>> result, List<int[]> vis) {
        if (i == n) {
            result.add(new ArrayList<>(singleResult));
            return;
        }

        for (int j = 0; j < n; j++) {
            int[] coordinate = {i, j};
            if (coordinateContain(vis, coordinate)) {
                continue;
            }
            singleResult.add(coordinate);

            // 计算下一排需要排除的坐标
            List<int[]> tempVis = new ArrayList<>();
            for (int[] t : singleResult) {
                int level = i + 1 - t[0];
                if (t[0] < n - level) {
                    tempVis.add(new int[]{t[0] + level, t[1]});
                    if (t[1] >= level) {
                        tempVis.add(new int[]{t[0] + level, t[1] - level});
                    }
                    if (t[1] < n - level) {
                        tempVis.add(new int[]{t[0] + level, t[1] + level});
                    }
                }
            }

//            System.out.println(Arrays.asList(tempVis.toArray()));
            vis.addAll(tempVis);
            nQueen0(n, singleResult, i + 1, result, vis);
            vis.removeAll(tempVis);
            singleResult.remove(coordinate);
        }
    }

    private static boolean coordinateContain(List<int[]> vis, int[] coordinate) {
        // 倒序遍历 更快获取结果，时间复杂度n，否则最长时为n*n
        for (int k = vis.size() - 1; k >= 0; k--) {
            if (vis.get(k)[0] == coordinate[0]) {
                if (vis.get(k)[1] == coordinate[1]) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    /**
     * 组合总数
     */
    static List<Deque<Integer>> combinationSum(int[] nums, int target) {
        List<Deque<Integer>> result = new ArrayList<>();
        Deque<Integer> singleResult = new LinkedList<>();

        Arrays.sort(nums);
        combinationSum0(nums, target, 0, singleResult, result, 0);
        return result;
    }

    static void combinationSum0(int[] nums, int target, int tempSum, Deque<Integer> singleResult, List<Deque<Integer>> result, int bg) {
        System.out.println("tempSum:" + tempSum + " singleResult:" + singleResult + " bg:" + bg);
        if (tempSum == target) {
            result.add(new LinkedList<>(singleResult));
            return;
        } else if (tempSum > target) {
            return;
        }

        for (int i = bg; i < nums.length; i++) {
            if (singleResult.size() == 0) {
                bg = i;
            }
            tempSum += nums[i];
            singleResult.push(nums[i]);
            combinationSum0(nums, target, tempSum, singleResult, result, bg);
            tempSum -= nums[i];
            singleResult.pop();
            if (singleResult.size() == 1) {
                bg++;
            }
//            System.out.println("tempSum2:" + tempSum + " singleResult:" + singleResult);
        }
    }

    /**
     * 组合总数2 每个数字在每个组合中只能使用一次
     */
    static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> singleResult = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];

        Arrays.sort(nums);
//        combinationSum20(nums, target, singleResult, result, 0);
        combinationSum200(nums, target, singleResult, result, 0, 0);
        return result;
    }

    static void combinationSum20(int[] nums, int target, List<Integer> singleResult, List<List<Integer>> result, int bg) {
        System.out.println("target:" + target + " singleResult:" + singleResult + " bg:" + bg);
        if (target == 0) {
            result.add(new LinkedList<>(singleResult));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = bg; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && singleResult.size() == 0) {
                continue;
            }

            if (singleResult.size() == 0) {
                bg = i;
            }
            singleResult.add(nums[i]);
            combinationSum20(nums, target - nums[i], singleResult, result, bg + 1);
            singleResult.remove(singleResult.size() - 1);
            bg = i;
        }
    }

    static void combinationSum200(int[] nums, int target, List<Integer> singleResult, List<List<Integer>> result, int bg, int lastRemove) {
        System.out.println("target:" + target + " singleResult:" + singleResult + " bg:" + bg);
        if (target == 0) {
            result.add(new LinkedList<>(singleResult));
            return;
        }

        for (int i = bg; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1] && nums[i] == lastRemove) {
                continue;
            }

            singleResult.add(nums[i]);
            combinationSum200(nums, target - nums[i], singleResult, result, bg + 1, lastRemove);
            lastRemove = singleResult.remove(singleResult.size() - 1);
            bg = i + 1;
//            System.out.println("target2:" + target + " singleResult:" + singleResult + " i:" + i);
        }
    }

    /**
     * 子集
     */
    static List<List<Integer>> subArray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> singleResult = new LinkedList<>();

//        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subArray0(nums, singleResult, result, i, 0);
        }

        return result;

    }

    static void subArray0(int[] nums, List<Integer> singleResult, List<List<Integer>> result, int count, int index) {
        System.out.println("count:" + count + " index:" + index + " singleResult" + singleResult);
        if (count == singleResult.size()) {
            result.add(new ArrayList<>(singleResult));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            singleResult.add(nums[i]);
            subArray0(nums, singleResult, result, count, i + 1);
            singleResult.remove(singleResult.size() - 1);
        }
    }

    /**
     * 子集2
     */
    static List<List<Integer>> subArray2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> singleResult = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
//            subArray0(nums, singleResult, result, i, 0);
            subArray20(nums, singleResult, result, i, 0, 0);
        }

        return result;

    }

    static void subArray20(int[] nums, List<Integer> singleResult, List<List<Integer>> result, int count, int index, int lastRemove) {
        System.out.println("count:" + count + " index:" + index + " singleResult" + singleResult);
        if (count == singleResult.size()) {
            result.add(new ArrayList<>(singleResult));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == lastRemove) {
                continue;
            }

            singleResult.add(nums[i]);
            subArray20(nums, singleResult, result, count, i + 1, lastRemove);
            lastRemove = singleResult.remove(singleResult.size() - 1);
        }
    }

    /**
     * 火柴棒拼正方形
     */
    static boolean matchsticks(int[] nums) {
        int side = 4;
        if (nums.length < side) {
            return false;
        }
        // 计算和 边长
        int sum = Arrays.stream(nums).sum();
        if (sum % side != 0) {
            return false;
        }
        int sideLength = sum / side;
        for (int num : nums) {
            if (num > sideLength) {
                return false;
            }
        }
        Arrays.sort(nums);

        List<Integer> singleResult = new LinkedList<>();
        List<Integer> vis = new LinkedList<>();
        matchsticks0(nums, sideLength, singleResult, vis);
        if (vis.size() == nums.length) {
            return true;
        }
        return false;
    }

    static void matchsticks0(int[] nums, int sideLength, List<Integer> singleResult, List<Integer> vis) {
        System.out.println("sideLength:" + sideLength + " singleResult:" + singleResult + " vis:" + vis);
        if (sideLength == 0) {
            vis.addAll(singleResult);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (singleResult.contains(i) || vis.contains(i)) {
                continue;
            }
            for (Integer s : singleResult) {
                if (vis.contains(s)) {
                    return;
                }
            }
            if (sideLength - nums[i] < 0) {
                continue;
            }

            singleResult.add(i);
            matchsticks0(nums, sideLength - nums[i], singleResult, vis);
            singleResult.remove(singleResult.size() - 1);
        }
    }
}
