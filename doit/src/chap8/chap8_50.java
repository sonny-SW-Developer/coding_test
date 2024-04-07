package chap8;
import java.util.*;
import java.io.*;

// 집합 표현하기 - 백준 1717(G4)
public class chap8_50 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent =new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(question == 0) {
                union(a,b);
            } else {
                if(checkSame(a,b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return true;
        else return false;
    }
}
