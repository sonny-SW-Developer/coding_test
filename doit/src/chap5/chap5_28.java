package chap5;
import java.util.*;
import java.io.*;

// 트리의 지름 구하기 - 백준 1167(G3)
public class chap5_28 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        A= new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            while(true) {
                int edge = Integer.parseInt(st.nextToken());
                if(edge == -1) break;
                int value = Integer.parseInt(st.nextToken());
                A[index].add(new Edge(edge, value));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1);
        int Max = 1;
        for(int i=2; i<=n; i++) {
            if(distance[Max] < distance[i]) {
                Max = i;
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        if(!queue.isEmpty()) {
            int node = queue.poll();
            for(Edge i: A[node]) {
                int e = i.edge;
                int v = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[node] + v;
                }
            }
        }
    }

}

class Edge {
    int edge;
    int value;

    Edge(int edge, int value) {
        this.edge = edge;
        this.value = value;
    }
}
