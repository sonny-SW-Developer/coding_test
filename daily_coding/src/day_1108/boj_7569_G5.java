package day_1108;
import java.util.*;
import java.io.*;
public class boj_7569_G5 {
    static int n, m, h;
    static int[] dx = { 0, 0, -1, 1, 0, 0 }; // 상,하,좌,우, 앞,뒤
    static int[] dy = { 1, -1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();

        // 가로 칸 수 (=y)
        m = Integer.parseInt(st.nextToken());
        // 세로 칸 수 (=x)
        n = Integer.parseInt(st.nextToken());
        // 상자 수(높이)
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1)
                        q.add(new int[] {i, j, k});
                }
            }
        }

        System.out.println(bfs(q));
    }

    static int bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curZ = cur[0];
            int curX = cur[1];
            int curY = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nz = curZ + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                    if (map[nz][nx][ny] == 0) {
                        q.add(new int[] {nz, nx, ny});
                        map[nz][nx][ny] = map[curZ][curX][curY] + 1;
                    }
                }
            }
        }

        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                    if (map[i][j][k] == 0) return -1;
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        // 최대 값이 1이라면 원래부터 모두 익어있었다는 것
        if (result == 1) return 0;
            // (최대 값 - 1) --> 걸린 일수
        else return (result - 1);
    }
}
