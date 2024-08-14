package day_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2927_D5 {
    // 코드 수정 필요 (틀린 코드)
    static int[] penguins;
    static int[] parent;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        penguins = new int[n+1];
        parent = new int[n+1];
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            penguins[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            calc(input, a, b);
        }
        System.out.println(sb.toString());
    }

    static void calc(String input, int a, int b) {
        // A -> B로 이동하는 경로. 불가능인 경우 "impossible" 출력
        if(input.equals("excursion")) {
            // 연결되어 있는 경우
            if(find(a) == find(b)) {
                int total = 0;
                for(int i=1; i<= penguins.length-1; i++) {
                    if(find(i) == find(a)) {
                        total += penguins[i];
                    }
                }
                sb.append(total).append("\n");
            } else {
                sb.append("impossible\n");
            }
        } else if (input.equals("bridge")) {
            // 다리가 이미 연결되어 있는 경우
            if(find(a) == find(b)) {
                sb.append("no\n");
            } else {
                union(a,b);
                sb.append("yes\n");
            }
        } else {
            penguins[a] = b;
        }
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
}
