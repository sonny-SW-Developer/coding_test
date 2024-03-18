package chap5;
import java.io.*;
import java.util.*;

// 미로 탐색하기 - 백준 2178(S1)
public class chap5_27 {
    static int[][] A;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String number = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(number.substring(j, j+1));;
            }
        }
        BFS(0,0);
        System.out.println(A[n-1][m-1]);

    }

    static void BFS(int v, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {v, j});
        visited[v][j] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0; k<4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >=0 && y >= 0 && x < n && y < m) {
                    if(A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
