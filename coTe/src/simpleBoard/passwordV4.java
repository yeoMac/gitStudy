package simpleBoard;

import java.lang.reflect.Array;
import java.util.Arrays;

public class passwordV4 {
    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];

        //(i * 3 + j)는 2D 배열을 1D 배열로 매핑하는 공식
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < password.length(); i++) {
            int from = (int) password.charAt(i - 1) - 48;
            int to = (int) password.charAt(i) - 48;
            answer += dist[from][to];
        }
        return answer;
    }
}
