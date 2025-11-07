import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int result = Arrays.binarySearch(nums, 8);
        System.out.println(result);

        int[] nums2 = new int[10];
        System.out.println(nums2.length);

        String str = "aaba";
        System.out.println(str.substring(3 , 4));

        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>(16);
        chm.put("123", "eee");
        chm.get("123");
        System.out.println(chm.size());

        int positiveNumber = 10;
        int negativeNumber = -10;

        // 逻辑右移 1 位
        int positiveResult = positiveNumber >>> 1;
        int negativeResult = negativeNumber >>> 1;

        System.out.println("正数 " + positiveNumber + " 逻辑右移 1 位结果: " + positiveResult);
        System.out.println("负数 " + negativeNumber + " 逻辑右移 1 位结果: " + negativeResult);

//        int positiveNumber = 10;
//        int negativeNumber = -10;
//
//        // 算术右移 1 位
//        int positiveResult = positiveNumber >> 1;
//        int negativeResult = negativeNumber >> 1;
//
//        System.out.println("正数 " + positiveNumber + " 算术右移 1 位结果: " + positiveResult);
//        System.out.println("负数 " + negativeNumber + " 算术右移 1 位结果: " + negativeResult);
    }
}