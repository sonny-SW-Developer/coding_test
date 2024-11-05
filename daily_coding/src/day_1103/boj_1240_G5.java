package day_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1240_G5 {
    static int n, m;
    static ArrayList<Node>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, value));
            A[b].add(new Node(a, value));
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[n+1];

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(BFS(a, b, visited)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int BFS(int a, int b, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        visited[a] = true;
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.end == b) {
                return cur.value;
            }

            for(Node next : A[cur.end]) {
                if(!visited[next.end]) {
                    visited[next.end] = true;
                    queue.add(new Node(next.end, cur.value + next.value));
                }
            }
        }

        return -1;
    }

    static class Node {
        int end;
        int value;

        Node (int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
}
