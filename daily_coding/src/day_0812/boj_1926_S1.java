package day_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1926_S1 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    list.add(BFS(i,j));
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        if(list.isEmpty()) {
            sb.append("0").append("\n").append("0");
        } else {
            sb.append(list.size()).append("\n").append(list.get(0));
        }
        System.out.println(sb.toString());
    }

    static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int tmpX = xy[0];
            int tmpY = xy[1];

            for(int i=0; i<4; i++) {
                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                        && map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    count++;
                }
            }
        }
        return count;
    }
}
