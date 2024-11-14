package day_1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_basic4_1219_D4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer>[] A = new ArrayList[100];
            boolean[] visited = new boolean[100];
            for(int i=0; i<100; i++) {
                A[i] = new ArrayList<>();
            }
            while(st.hasMoreTokens()) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
            }

            DFS(0, A, visited);

            sb.append("#").append(num).append(" ").append(visited[99] ? "1" : "0").append("\n");
        }
        System.out.print(sb.toString());
    }

    static void DFS(int num, ArrayList<Integer>[] A, boolean[] visited) {
        visited[num] = true;

        for(int n : A[num]) {
            if(!visited[n]) {
                DFS(n, A, visited);
            }
        }
    }
}
