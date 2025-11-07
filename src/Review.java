import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Review {
    public static void main(String[] args) {

        // HashMap HashTable ConcurrentHashMap
        HashMap<String, String> hm = new HashMap<>(16);
        hm.put("123", "eee");
        System.out.println(hm.size());

        // ConcurrentHashMap node数组，线程安全使用cas和synchronized
        /** cas获取和更新node，synchronized锁 node */
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>(16);
//        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>(16, 0.75f);
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