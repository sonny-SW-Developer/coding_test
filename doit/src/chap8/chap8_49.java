package chap8;
import java.util.*;
import java.io.*;

// 물의 양 구하기 - 백준 2251(G5)
public class chap8_49 {
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[][] visited;
    static boolean answer[];
    static int now[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        now = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();
        for(int i=0; i<answer.length; i++) {
            if(answer[i]) System.out.print(i + " ");
        }
    }
    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()) {
            AB p = queue.poll();
            int a = p.A;
            int b = p.B;
            int c = now[2] - a- b;
            for(int i=0; i<6; i++){
                int[] next = {a,b,c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                // 물이 넘칠 때
                if(next[receiver[i]] > now[receiver[i]]) {
                    // 초과하는 만큼 다시 이전 물통에 넣어줌
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }

                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;
    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}