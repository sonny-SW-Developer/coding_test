package day_1121;
import java.util.*;
public class pg_86971_Lv2 {
    static ArrayList<Integer>[] A;
    static int min;

    static int solution(int n, int[][] wires) {
        min = Integer.MAX_VALUE;

        // 그래프 초기화
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int[] wire : wires) {
            A[wire[0]].add(wire[1]);
            A[wire[1]].add(wire[0]);
        }

        // 모든 간선 제거 및 확인
        for (int[] wire : wires) {
            // 간선 제거
            A[wire[0]].remove(Integer.valueOf(wire[1]));
            A[wire[1]].remove(Integer.valueOf(wire[0]));

            // 방문 배열 초기화
            boolean[] visited = new boolean[n + 1];

            // 한쪽 트리 크기 계산
            int count = DFS(wire[0], visited);

            // 두 트리 크기 차이 계산
            min = Math.min(min, Math.abs(count - (n - count)));

            // 간선 복구
            A[wire[0]].add(wire[1]);
            A[wire[1]].add(wire[0]);
        }

        return min;
    }

    static int DFS(int start, boolean[] visited) {
        visited[start] = true;
        int count = 1;

        for (int next : A[start]) {
            if (!visited[next]) {
                count += DFS(next, visited);
            }
        }

        return count;
    }
}
