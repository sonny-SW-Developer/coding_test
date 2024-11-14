package day_1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_2665_G4 {
    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = input.charAt(j) - '0';
                // 초기 거리 무한대로 지정
                dist[i][j] = MAX;
            }
        }

        solution();
        System.out.println(dist[n-1][n-1]);
    }

    static void solution() {
        // 벽 부순 비용 적은 순으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0,0,0}); // {x, y, 부순 벽 수}
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int brokeWalls = cur[2];

            // 이미 최소값으로 갱신한 경우, 탐색 종료
            if(dist[x][y] < brokeWalls) continue;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newBrokeWalls = brokeWalls + (map[nx][ny] == 0 ? 1 : 0);
                    if(newBrokeWalls < dist[nx][ny]) {
                        dist[nx][ny] = newBrokeWalls;
                        pq.add(new int[]{nx,ny,newBrokeWalls});
                    }
                }
            }
        }
    }
}
