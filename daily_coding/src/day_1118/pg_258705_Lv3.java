package day_1118;

public class pg_258705_Lv3 {
    // 2024 카카오 겨울 인턴십 - 산 모양 타일링(Level 3)
    // https://school.programmers.co.kr/learn/courses/30/lessons/258705
    static int solution(int n, int[] tops) {
        int mod = 10007;
        int[][] dp = new int[n][2];

        // 초기값 풀이 그림 참고
        dp[0][0] = tops[0] == 1 ? 3 : 2;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            int mul1 = tops[i] == 1 ? 3 : 2;
            int mul2 = tops[i] == 1 ? 2 : 1;

            dp[i][0] = (dp[i - 1][0] * mul1 + dp[i - 1][1] * mul2) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        return (dp[n - 1][0] + dp[n - 1][1]) % mod;
    }
}
