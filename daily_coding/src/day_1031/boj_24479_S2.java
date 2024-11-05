package day_1031;
import java.util.*;
import java.io.*;

public class boj_24479_S2 {
    static int n,m,r;
    static ArrayList<Integer>[] A;
    static int[] visited;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(A[i]);
        }

        visited = new int[n+1];
        cnt = 1;
        DFS(r);

        for(int i=1; i<=n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int num) {
        visited[num] = cnt;

        for(int n : A[num]) {
            if(visited[n] == 0) {
                cnt++;
                DFS(n);
            }
        }
    }
}
