package day_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2583_S1 {
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            drawRectangle(leftX, leftY, rightX, rightY);
        }

        // 사이즈 다른 것 출력하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 직사각형이 아니면서, 방문하지 않은 경우
                if(graph[i][j] != -1 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void drawRectangle(int lx, int ly, int rx, int ry) {
        for(int i= lx; i<rx; i++) {
            for(int j = n - ry; j< n - ly; j++) {
                graph[j][i] = -1;
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count=1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && graph[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    count++;
                }
            }
        }
        return count;
    }
}
