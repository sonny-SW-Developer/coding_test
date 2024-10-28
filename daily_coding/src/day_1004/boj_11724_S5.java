package day_1004;
import java.util.*;
import java.io.*;

public class boj_11724_S5 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                ans++;
                solution(i);
            }
        }
        System.out.println(ans);
    }

    static void solution(int n) {
        if(visited[n]) return;

        visited[n] = true;
        for(int num : A[n]) {
            if(!visited[num]) {
                solution(num);
            }
        }
    }
}
