package day_1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485_G4 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n==0) break;

            map = new int[n][n];
            visited = new boolean[n][n];

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(++index).append(": ").append(BFS()).append("\n");
        }


        System.out.println(sb.toString());
    }

    static int BFS() {
        PriorityQueue<Loopy> queue = new PriorityQueue<>();
        queue.add(new Loopy(0,0,map[0][0]));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Loopy temp = queue.poll();
            if(temp.x == n-1 && temp.y == n-1) {
                return temp.value;
            }
            for(int i=0; i<4; i++) {
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Loopy(nx,ny,temp.value + map[nx][ny]));
                }
            }
        }

        return -1;
    }

    static class Loopy implements Comparable<Loopy> {
        int x;
        int y;
        int value;

        Loopy(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Loopy l) {
            return this.value - l.value;
        }
    }
}
