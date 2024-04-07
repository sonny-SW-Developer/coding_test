package chap8;

import java.util.*;
import java.io.*;

public class chap8_46 {
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static int n,m,k,x;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new int[n+1];
        answer = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        for(int i=0; i<=n; i++) {
            visited[i] = -1;
        }

        BFS(x);
        for(int i=0; i<=n; i++) {
            if(visited[i] == k) answer.add(i);
        }
        if(answer.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(answer);
            for(int temp: answer) {
                System.out.println(temp);
            }
        }
    }

    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num]++;
        while (!queue.isEmpty()) {
            int new_number = queue.poll();
            for(int i : arr[new_number]) {
                if(visited[i] == -1) {
                    visited[i] = visited[new_number] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
