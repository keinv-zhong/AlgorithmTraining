package calculate;

import java.util.*;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(phoneNumber("23"));
        System.out.println(phoneNumber("239"));
    }

    /**
     * 电话号码的字母组合
     * */
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

        for (Character c : digits.toCharArray()) {
            List<Character> characters = numberMap.get(c);
            if (null != characters && !characters.isEmpty()) {

            }
        }

        return result;
    }
}
