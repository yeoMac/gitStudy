package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckNumberAndAddNumV1 {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(answer("aaabc")));
        System.out.println(Arrays.toString(answer("aabb")));
        System.out.println(Arrays.toString(answer("abcde")));
        System.out.println(Arrays.toString(answer("abcdeabc")));
    }

    public static int[] answer(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int[] counts = new int[5];
        for (char c = 'a'; c < 'e'; c++) {
            counts[c - 'a'] = map.getOrDefault(c, 0);
        }

        int maxFreq = Arrays.stream(counts).max().getAsInt();

        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            result [i] = maxFreq - counts[i];
        }
        return result;
    }
}
