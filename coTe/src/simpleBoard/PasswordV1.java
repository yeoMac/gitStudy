package simpleBoard;

import java.util.HashMap;
import java.util.Map;

public class PasswordV1 {

    public static int passwordTime(int[][] keypad, int[] password) {
        // 숫자 위치를 지정할 Map
        Map<Integer, int[]> pos = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos.put(keypad[i][j], new int[]{i, j});
            }
        }

        int totalTime = 0;

        // 첫 번째 숫자의 좌표
        int[] prev = pos.get(password[0]);

        //비밀번호 숫자를 순차적으로 탐색
        for (int i = 1; i < password.length; i++) {
            int[] curr = pos.get(password[i]);  //이렇게 하면 몇행 몇열인지 알 수 있음

            //행과 열의 차이 계산
            int rowDiff = Math.abs(prev[0] - curr[0]);
            int colDiff = Math.abs(prev[1] - curr[1]);

            //이웃한 숫자만 1초, 아니면 2초
            if (prev[0] == curr[0] && prev[1] == curr[1]) {
                totalTime += 0;
            } else if (rowDiff <= 1 && colDiff <= 1) {
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

        System.out.println(passwordTime(keypad, password));
    }
}
