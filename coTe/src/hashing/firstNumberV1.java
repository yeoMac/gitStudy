package hashing;

import java.util.HashMap;
import java.util.Map;

public class firstNumberV1 {
    public static void main(String[] args) {

        String input = "statitsics";
        String[] arr = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = String.valueOf(input.charAt(i));
        }

        int result = answer(arr);
        System.out.println(result);
    }

    private static int answer(String[] arr) {


        Map<Integer, String[]> point = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String[] strings = point.get(i);
            point.put(i, strings);
        }


        return 0;
    }
}
