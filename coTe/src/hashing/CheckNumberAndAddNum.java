package hashing;

import java.util.Arrays;

public class CheckNumberAndAddNum {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(answer("aaabc")));
        System.out.println(Arrays.toString(answer("aabb")));
        System.out.println(Arrays.toString(answer("abcde")));
        System.out.println(Arrays.toString(answer("abcdeabc")));
    }

    public static int[] answer(String s) {

        int[] arr = new int[5];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'e') {
                arr[c - 'a']++;
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();

        int[] result = new int[5];
        for (int i = 0; i < result.length; i++) {
            result[i] = max - arr[i];
        }

        return result;
    }
}
