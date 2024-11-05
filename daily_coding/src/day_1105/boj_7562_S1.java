package day_1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562_S1 {
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,-2,-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[] arr = new int[4];
            StringTokenizer st;

            // 시작 위치
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());

            // 목표 위치
            st = new StringTokenizer(br.readLine());
            arr[2] = Integer.parseInt(st.nextToken());
            arr[3] = Integer.parseInt(st.nextToken());
            sb.append(BFS(arr, map)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int BFS(int[] arr, int[][] map) {
        int len = map.length;
        boolean[][] visited = new boolean[len][len];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {arr[0], arr[1], 0});
        visited[arr[0]][arr[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = cur[2];

            if(curX == arr[2] && curY == arr[3]) {
                return count;
            }
            for(int i=0; i<8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < len && ny < len && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny, count+1});
                }
            }
        }
        return -1;
    }
}
