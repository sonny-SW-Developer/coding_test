package chap5;
import java.util.*;
import java.io.*;
public class ex5_2 {
    static int n,m;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()) {
            Pair tmp = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(arr[nx][ny] == 0) continue;
                if (arr[nx][ny] == 1){
                    arr[nx][ny] = arr[tmp.x][tmp.y] + 1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        return arr[n-1][m-1];
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
