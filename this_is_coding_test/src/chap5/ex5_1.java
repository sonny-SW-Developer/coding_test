package chap5;
import java.util.*;
import java.io.*;
public class ex5_1 {
    static int n,m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(i, j)) answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        if(arr[x][y] == 0) {
            arr[x][y] = 1;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
}
