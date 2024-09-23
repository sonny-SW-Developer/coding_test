import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];
        visited = new boolean[n][n];

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) {
                int num = input.charAt(j) - '0';
                graph[i][j] = num == 1;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && graph[i][j]) {
                    list.add(bfs(i,j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx][ny] && !visited[nx][ny]) {
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }
}