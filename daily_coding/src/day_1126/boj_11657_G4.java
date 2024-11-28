package day_1126;
import java.util.*;
import java.io.*;

public class boj_11657_G4 {
    // 타임머신(G4) - 벨만포드 알고리즘 사용
    // https://www.acmicpc.net/problem/11657
    static ArrayList<Node>[] A;
    static int n,m;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시 개수
        n = Integer.parseInt(st.nextToken());
        // 버스 노선 개수
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, cost));
        }

        if(!bellmanFord(1)) {
            // 음수 사이클 존재하는 경우
            System.out.println(-1);
        } else {
            for(int i=2; i<=n; i++) {
                if(dist[i] == INF) {
                    // 도달 불가능한 경우
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static boolean bellmanFord(int start) {
        dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i=1; i<n; i++) {
            for(int j=1; j<=n; j++) {
                for(Node node : A[j]) {
                    if(dist[j] != INF && dist[node.end] > dist[j] + node.cost) {
                        dist[node.end] = dist[j] + node.cost;
                    }
                }
            }
        }

        // 음수 사이클 체크
        for(int j=1; j<=n; j++) {
            for(Node node : A[j]) {
                if(dist[j] != INF && dist[node.end] > dist[j] + node.cost) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
