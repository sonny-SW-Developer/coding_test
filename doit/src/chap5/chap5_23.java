package chap5;
import java.util.*;
import java.io.*;

// 연결 요소의 개수 구하기 - 백준 11724(S5)
public class chap5_23 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 양방향 엣지이므로
            A[start].add(end);
            A[end].add(start);
        }

        int count = 0;
        for(int i=1; i<=n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if(visited[v]) return;
        visited[v] = true;
        for (int i : A[v]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }
    }
}
