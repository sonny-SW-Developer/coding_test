package day_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11729_G5 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2,input)-1)).append("\n");

        hanoi(input, 1,2,3);
        System.out.println(sb.toString());
    }

    // N : 원판 개수
    // start : 출발지
    // mid : 옮기기 위해 이동해야 하는 장소
    // to : 목적지
    static void hanoi(int input, int start, int mid, int to) {
        // 원반의 수가 1개인 경우
        if(input == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        // start 지점의 n-1개 원판을 mid 지점으로 옮긴다.
        hanoi(input-1, start, to, mid);

        // A -> C로 이동
        sb.append(start + " " + to + "\n");

        // N-1개 원판을 B -> C로 이동
        hanoi(input-1, mid, start, to);
    }
}
