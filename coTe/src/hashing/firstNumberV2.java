package hashing;

import java.util.HashMap;
import java.util.Map;

public class firstNumberV2 {
    public static void main(String[] args) {
        System.out.println(getFirstUniqueIndex("statitsics")); // 3
        System.out.println(getFirstUniqueIndex("aabb")); // -1
        System.out.println(getFirstUniqueIndex("stringshowtime")); // 3
        System.out.println(getFirstUniqueIndex("abcdeabcdfg")); // 5
    }

    private static int getFirstUniqueIndex(String s) {

        Map<Character, Integer> sh = new HashMap<>();
        for (char c : s.toCharArray()) {
            sh.put(c, sh.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (sh.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
