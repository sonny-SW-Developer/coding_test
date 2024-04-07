package chap8;
import java.util.*;
import java.io.*;

// 효율적으로 해킹하기 - 백준 1325(S1)
public class chap8_47 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        answer = new int[n+1];
        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        // 모든 노드에서 BFS 실행
        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];
//            BFS(i);
            DFS(i);
        }

        int max = 0;
        for(int i=1; i<=n; i++) {
            max = Math.max(max, answer[i]);
        }

        for(int i=1; i<=n; i++) {
            if(max == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void DFS(int num) {
        visited[num] = true;
        for(int vv : A[num]) {
            if(!visited[vv]) {
                answer[vv]++;
                DFS(vv);
            }
        }
    }

    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int i : A[next]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
