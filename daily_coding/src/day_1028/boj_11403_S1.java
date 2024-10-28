package day_1028;
import java.util.*;
import java.io.*;
public class boj_11403_S1 {
    static ArrayList<Integer>[] A;
    static int num;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        A = new ArrayList[num];
        answer = new int[num][num];

        for (int i = 0; i < num; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int cur = Integer.parseInt(st.nextToken());
                // 방향 그래프 성립
                if (cur == 1) {
                    A[i].add(j);
                }
            }
        }


        for (int i = 0; i < num; i++) {
            boolean[] visited = new boolean[num];
            // Node 탐색 - DFS
            DFS(i, i, visited);

            // BFS
//            BFS(i, num);
        }

        // 결과 출력
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }


    static void DFS(int start, int node, boolean[] visited) {
        for (int next : A[node]) {
            if (!visited[next]) {
                visited[next] = true;
                answer[start][next] = 1;
                DFS(start, next, visited);
            }
        }
    }

    static void BFS(int start, int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[num];

        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : A[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer[start][next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}
