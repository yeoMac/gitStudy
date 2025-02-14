package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckNumberAndAddNumV2 {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(answer("aaabc")));
        System.out.println(Arrays.toString(answer("aabb")));
        System.out.println(Arrays.toString(answer("abcde")));
        System.out.println(Arrays.toString(answer("abcdeabc")));
    }

    public static int[] answer(String s) {

        int[] answer = new int[5];
        HashMap<Character, Integer> sh = new HashMap<>();
        for (char c : s.toCharArray()) {
            sh.put(c, sh.getOrDefault(c, 0) + 1);
        }

        int max =Integer.MIN_VALUE;
        String tmp = "abcde";
        for (char key : tmp.toCharArray()) {
            if (sh.getOrDefault(key, 0) > max) {
                max = sh.getOrDefault(key, 0);
            }
        }
        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = max - sh.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }
}
