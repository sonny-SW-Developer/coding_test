package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2169_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];

        // 이미 방문한 곳은 방문할 수 없으므로, 0행은 오른쪽으로만 이동 가능
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        // 각 행에 대해 계산
        for (int i = 1; i < N; i++) {
            // 1. 왼쪽에서 오는 경우
            int[] left = new int[M];
            left[0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j-1], dp[i-1][j]) + map[i][j];
            }

            // 2. 오른쪽에서 오는 경우
            int[] right = new int[M];
            right[M-1] = dp[i-1][M-1] + map[i][M-1];
            for (int j = M-2; j >= 0; j--) {
                right[j] = Math.max(right[j+1], dp[i-1][j]) + map[i][j];
            }

            // 3. 현재 행의 dp 계산
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
