package day_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_G4 {
    static int n,m;
    static int[][] graph; // 연구소 상태 저장
    static int[][] temp; // 벽 세운 후 임시 연구소 상태 저장
    static int maxArea = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        temp = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개 세구이
        buildWalls(0);
        System.out.println(maxArea);
    }

    static void buildWalls(int count) {
        if(count == 3) {
            // 바이러스 퍼뜨리기
            spreadVirus();
            return ;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 벽 세울 수 있는 경우
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    buildWalls(count+1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static void spreadVirus() {
        Queue<int []> queue = new LinkedList<>();

        // 연구소 상태 temp에 복사
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[i][j] = graph[i][j];
            }
        }

        // 바이러스 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {  // 바이러스(2)인 곳
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // BFS로 바이러스 퍼뜨리기
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (temp[nx][ny] == 0) {  // 빈 칸(0)이면 바이러스 퍼뜨리기
                        temp[nx][ny] = 2;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        calSafeArea();
    }

    // 안전 구역 계산
    static void calSafeArea() {
        int safe = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(temp[i][j] == 0) {
                    safe++;
                }
            }
        }
        maxArea = Math.max(maxArea, safe);
    }
}
