package training;

public class InterviewTrain {

    /**
     * 哈沙德数
     */
    static int harshadNumber(int n) {
        String str = String.valueOf(n);
        char[] ch = str.toCharArray();

        int total = 0;
        for (int i = 0; i < ch.length; i++) {
            total += ch[i] - '0';
        }
//        System.out.println(total);
        if (n % total == 0) {
            return total;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 18};
//        int[] result = moveArray(nums, 2);
        System.out.println(harshadNumber(18));
        System.out.println(harshadNumber(23));
    }

}