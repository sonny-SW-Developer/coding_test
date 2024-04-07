package chap8;
import java.util.*;
import java.io.*;

// 여행 계획 짜기 - 백준 1976(G4)
public class chap8_51 {
    static int[] trip;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dosi = new int[n+1][n+1];
        StringTokenizer st;
        trip = new int[n+1];
        for(int i=1; i<= n; i++) {
            trip[i] = i;
        }

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                dosi[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] route = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 행렬에서 도시가 연결되어 있으면 union 실행하기
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(dosi[i][j] == 1) union(i,j);
            }
        }

        // 여행 계획 도시들이 1개의 대표 도시로 연결되어 있는지 확인하기
        int index = find(route[1]);
        for(int i=2; i<route.length; i++) {
            if(index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if( a != b) trip[b] = a;
    }

    static int find(int a) {
        if(a == trip[a]) return a;
        else return trip[a] = find(trip[a]);
    }
}
