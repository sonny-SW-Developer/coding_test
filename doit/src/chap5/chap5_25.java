package chap5;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// 친구 관계 파악하기 - 백준 13023(G5)
public class chap5_25 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        A = new ArrayList[n];
        for(int i=0; i<n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        for(int i=0; i<n; i++) {
            DFS(i, 1);
        }
    }

    static void DFS(int now, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return ;
        }
        visited[now] = true;
        for(int i: A[now]) {
            if(!visited[i]) {
                DFS(i, depth+1);
            }
        }
        visited[now] = false;
    }
}
