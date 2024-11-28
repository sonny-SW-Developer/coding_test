package day_1124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1446_S1 {
    // 지름길 : 백준 S1 (1446)
    // 링크 : https://www.acmicpc.net/problem/1446
    static int[][] graph;
    static int[] dp;
    static int n, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        graph = new int[n][3];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 모든 거리를 이동하는데 필요한 최소 거리 저장
        dp = new int[d+1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        // DP 수행
        getShortestPath();
    }

    static void getShortestPath() {
        for(int i=0; i<= d; i++) {
            if(i> 0) {
                // 지름길X, 고속도로 이동
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            }

            for(int [] path : graph) {
                int start = path[0];
                int end = path[1];
                int dist = path[2];

                if(i==start && end <= d) {
                    dp[end] = Math.min(dp[end], dp[start] + dist);
                }
            }
        }

        System.out.println(dp[d]);
    }
}
