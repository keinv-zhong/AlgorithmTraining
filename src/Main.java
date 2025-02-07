import java.util.Arrays;

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
    }
}