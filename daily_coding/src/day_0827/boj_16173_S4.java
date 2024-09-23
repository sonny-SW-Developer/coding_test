package day_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16173_S4 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        if(found) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void dfs(int x, int y) {
        if(x >=n || y >= n || x < 0 || y < 0) return;
        if(visited[x][y]) return;
        if (x == n-1 && y == n-1) {
            found = true;
            return;
        }

        visited[x][y] = true;
        // 오른쪽으로 이동
        int ny = y + map[x][y];
        dfs(x, ny);
        // 아래로 이동
        int nx = x + map[x][y];
        dfs(nx, y);
    }
}
