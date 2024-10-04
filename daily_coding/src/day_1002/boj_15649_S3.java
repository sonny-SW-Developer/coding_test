package day_1002;
import java.util.*;
import java.io.*;
public class boj_15649_S3 {
    static int[] arr;
    static boolean[] visited;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n+1];
        backTracking(0);

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    static void backTracking(int depth) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
