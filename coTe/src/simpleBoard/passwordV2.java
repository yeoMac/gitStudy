package simpleBoard;

import java.util.HashMap;
import java.util.Map;

public class passwordV2 {

    public static int findPassword(int[][] keypad, int[] password) {

        if (password.length > 20000) {
            return -1;
        }
        int totalTime = 0;
        Map<Integer, int[]> point = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                point.put(keypad[i][j], new int[]{i, j});
            }
        }
        //현재 배열의 위치
        int[] prev = point.get(password[0]);
        for (int i = 0; i < password.length; i++) {

            int[] curr = point.get(password[i]);
            int rowDiff = Math.abs(curr[0] - prev[0]);
            int colDiff = Math.abs(curr[1] - prev[1]);

            if (rowDiff == 0 && colDiff == 0) {
                continue;
            }
            if (rowDiff <= 1 && colDiff <= 1) {
                totalTime += 1;
            } else {
                totalTime += 2;
            }

            prev = curr;

        }
        return totalTime;
    }
    public static void main(String[] args) {
        int[][] keypad = {
                {7, 5, 9},
                {6, 2, 1},
                {8, 3, 4}
        };
        int[] password = {7, 5, 9, 6, 2, 1, 8};

        int result = findPassword(keypad, password);
        if (result == -1) {
            System.out.println("패스워드의 길이가 20000이상입니다.");
        } else {
            System.out.println(result);
        }
    }
}
