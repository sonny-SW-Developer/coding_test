package chap8;
import java.util.*;
import java.io.*;

public class chap8_48 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t=0; t<n; t++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            A = new ArrayList[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];
            isEven = true;

            for(int i=1; i<=v; i++) {
                A[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            for(int i=1; i<=v; i++) {
                if(isEven) DFS(i);
                else break;
            }

            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
                isEven = false;
            }
        }
    }

}
