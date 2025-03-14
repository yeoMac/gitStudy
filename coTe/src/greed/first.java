package greed;

import java.util.ArrayList;
import java.util.List;

public class first {

    public static void main(String[] args) {
        int[] weights = {3, 2, 4}; // 물건 무게
        int[] values = {60, 100, 120}; // 물건 가치
        int capacity = 5; // 배낭 무게 제한
        int n = weights.length;

        // DP 테이블 초기화
        int[][] dp = new int[n + 1][capacity + 1];

        // DP 알고리즘
        for (int i = 1; i <= n; i++) { // 물건 하나씩 고려
            for (int w = 1; w <= capacity; w++) { // 배낭의 무게 제한
                if (weights[i - 1] <= w) {
                    // 현재 물건을 넣을 수 있을 때, 넣는 경우와 안 넣는 경우 비교
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // 현재 물건을 넣을 수 없으면 이전 상태 유지
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("배낭에 넣을 수 있는 최대 가치: " + dp[n][capacity]);
    }
}
