package chap5;
import java.util.*;
import java.io.*;

// DFS와 BFS 프로그램 - 백준 1260(S2)
public class chap5_26 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        // 작은 것부터 오름차순으로 정렬
        for(int i=1; i<=n; i++) {
            Collections.sort(A[i]);
        }

        DFS(v);
        System.out.println(sb.toString());
        visited = new boolean[n+1];
        sb = new StringBuilder();
        BFS(v);
        System.out.println(sb.toString());
    }

    static void DFS(int v) {
        if(visited[v]) return;
        visited[v] = true;
        sb.append(v + " ");
        for(int i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
    
    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");
            for (int i: A[node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
