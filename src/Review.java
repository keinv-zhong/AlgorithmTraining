import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Review {
    public static void main(String[] args) {

        // HashMap HashTable ConcurrentHashMap
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap(16);
        chm.put("123", "eee");
        System.out.println(chm.size());

//        int positiveNumber = 10;
//        int negativeNumber = -10;
//
//        // 逻辑右移 1 位
//        int positiveResult = positiveNumber >>> 1;
//        int negativeResult = negativeNumber >>> 1;
//
//        System.out.println("正数 " + positiveNumber + " 逻辑右移 1 位结果: " + positiveResult);
//        System.out.println("负数 " + negativeNumber + " 逻辑右移 1 位结果: " + negativeResult);

        int positiveNumber = 10;
        int negativeNumber = -10;

        // 算术右移 1 位
        int positiveResult = positiveNumber >> 1;
        int negativeResult = negativeNumber >> 1;

        System.out.println("正数 " + positiveNumber + " 算术右移 1 位结果: " + positiveResult);
        System.out.println("负数 " + negativeNumber + " 算术右移 1 位结果: " + negativeResult);
    }
}