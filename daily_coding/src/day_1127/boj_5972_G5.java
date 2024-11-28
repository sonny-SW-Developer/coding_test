package day_1127;
import java.util.*;
import java.io.*;
public class boj_5972_G5 {
    static ArrayList<Node>[] A;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, value));
            A[end].add(new Node(start, value));
        }

        dijkstra(1);
        System.out.println(dist[n]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.end;
            int curValue = cur.value;

            if(curValue > dist[curNode]) continue;

            for(Node next : A[curNode]) {
                int nextNode = next.end;
                int nextValue = curValue + next.value;

                if(nextValue < dist[nextNode]) {
                    dist[nextNode] = nextValue;
                    pq.add(new Node(nextNode, nextValue));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end;
        int value;

        Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }
}
