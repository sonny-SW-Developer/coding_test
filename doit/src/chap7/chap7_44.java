package chap7;
import java.util.*;
import java.io.*;

public class chap7_44 {
    static ArrayList<Node>[] A;
    // 최소 공배수
    static long lcm;
    // 탐색 여부 저장 배열
    static boolean[] visited;
    // 각 노드값 저장 배열
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        A = new ArrayList[n];
        visited = new boolean[n];
        D = new long[n];
        lcm = 1;

        for(int i=0; i<n; i++) {
            A[i] = new ArrayList<Node>();
        }

        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            // 최소 공배수 업데이트
            lcm *= (p*q / gcd(p,q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i=1; i<n; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i=0; i<n; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void DFS(int node) {
        visited[node] = true;
        for(Node n : A[node]) {
            int next = n.getB();
            if(!visited[next]) {
                D[next] = D[node] * n.getQ() / n.getP();
                DFS(next);
            }
        }
    }
}

class Node {
    // 다음 노드
    int b;
    // 비율 P
    int p;
    // 비율 Q
    int q;
    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }
    public int getP() {
        return p;
    }
    public int getQ() {
        return q;
    }
}
