package simpleBoard;

import java.util.HashMap;
import java.util.Map;

public class passwordV3Debug {
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

    private static int findPassword(int[][] keypad, int[] password) {
        if (password.length >= 20000) {
            return -1;
        }

        int totalTime = 0;
        Map<Integer, int[]> point = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                point.put(keypad[i][j], new int[]{i, j});
            }
        }

        int[] prev = point.get(password[0]);

        System.out.println("초기 위치 : " + password[0] +"-> (" + prev[0] + "," + prev[1] + ")");

        for (int i = 1; i < password.length; i++) {
            int[] curr = point.get(password[i]);

            System.out.println("현재 위치 : " + password[i] + "-> (" + curr[0] + "," +curr[1] + ")");
            System.out.println("이전 위치 : " + password[i-1] + "-> (" + prev[0] + "," + prev[1] + ")");
            int rowDiff = Math.abs(curr[0] - prev[0]);
            int colDiff = Math.abs(curr[1] - prev[1]);

            System.out.println("rowDiff:" + rowDiff + ", colDiff: " + colDiff);


            if (prev[0] == curr[0] && prev[1] == curr[1]) {
                System.out.println("같은 숫자 연속 입력 → 시간 증가 없음");
                totalTime += 0;
            }else if (rowDiff <= 1 && colDiff <= 1) {
                System.out.println("이웃한 숫자 이동 -> +1");
                totalTime +=1;
            }else {
                System.out.println("떨어져 있는 숫자 이동 +2");
                totalTime +=2;
            }


        }
        return totalTime;
    }
}
