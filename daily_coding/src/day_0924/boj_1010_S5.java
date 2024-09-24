package day_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010_S5 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(calGraph(a,b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int calGraph(int a, int b) {
        int c = Math.max(a,b);
        int[][] graph = new int[c+1][c+1];

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[0].length; j++) {
                if(i>j) continue;
                if(i==0) {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = graph[i-1][j-1] + graph[i][j-1];
                }
            }
        }

        return graph[a][b];
    }
}
