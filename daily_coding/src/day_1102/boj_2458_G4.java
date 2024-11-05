package day_1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2458_G4 {
    static int n, m;
    static boolean[][] dist;
    static final int MAXVAL = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new boolean[n+1][n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b보다 키가 작다.
            dist[a][b] = true;
        }

        // 플로이드-워셜 알고리즘
        for(int k=1; k<=n; k++) { // 중간
            for(int i=1; i<=n; i++) { // 시작
                for(int j=1; j<=n; j++) { // 도착
                    // i가 k보다 작고, k가 j보다 작다면 i는 j보다 작다.
                    if(dist[i][k] && dist[k][j]) {
                        System.out.println("k: " + k + ", i: " + i + ", j: " + j);
                        dist[i][j] = true;
                    }
                }
            }
        }

        // 자신의 순서를 알 수 있는 학생 수
        int count=0;
        for(int i=1; i<=n; i++) {
            int known = 0;
            for(int j=1; j<=n; j++) {
                if(dist[i][j] || dist[j][i]) {
                    known++;
                }
            }

            // 자신을 제외한 모든 학생과의 관계를 알 수 있으면, 순서를 알 수 있음
            if(known == n-1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
