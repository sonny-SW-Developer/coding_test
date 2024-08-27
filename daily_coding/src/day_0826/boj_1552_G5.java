package day_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_1552_G5 {
    static int n;
    static int[][] board;
    static boolean[] visited;
    static ArrayList<Integer> minos;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        // 최소 점수, 최대 점수 값 저장
        answer = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) {
                char c = input.charAt(j);
                if(Character.isDigit(c)) {
                    // 0~9
                    board[i][j] = c - '0';
                } else {
                    // A~I
                    board[i][j] = -(c - 'A' + 1);
                }
            }
        }

        minos = new ArrayList<>();
        visited = new boolean[n];
        permutate(0);

        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append("\n").append(answer[1]);
        System.out.println(sb.toString());
    }

    // 순열 생성
    static void permutate(int depth) {
        if(depth == n) {
            // 순환 만들어 졌으므로, 점수 계산
            calScore();
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                minos.add(i);
                permutate(depth+1);
                minos.remove(minos.size() - 1);
                visited[i] = false;
            }
        }
    }

    static void calScore() {
        int score = 1;
        int cycles = 0;
        boolean[] cycleVisited = new boolean[n];

        for(int i=0; i<n; i++) {
            score *= board[i][minos.get(i)];
        }

        // 사이클 개수 확인
        for(int i=0; i<n; i++) {
            if(!cycleVisited[i]) {
                cycles++;
                int cur = i;
                while(!cycleVisited[cur]) {
                    cycleVisited[cur] = true;
                    cur = minos.get(cur);
                }
            }
        }

        // 짝수라면 -1 곱함
        if(cycles % 2 == 0) {
            score *= -1;
        }

        answer[0] = Math.min(answer[0], score);
        answer[1] = Math.max(answer[1], score);
    }
}
