package day_1113;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_basic2_1211_D4 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int num = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            // 입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int minDistance = Integer.MAX_VALUE;
            int bestStart = 0;

            // 가능한 출발점 찾기 (첫 행의 '1'에서 시작)
            for (int start = 0; start < 100; start++) {
                if (arr[0][start] == 1) {
                    int distance = simulatePath(start);
                    // 최단 거리 또는 같은 거리일 때 큰 x좌표 선택
                    if (distance < minDistance || (distance == minDistance && start > bestStart)) {
                        minDistance = distance;
                        bestStart = start;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(bestStart).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 경로 시뮬레이션 메서드
    static int simulatePath(int start) {
        int x = 0, y = start;
        int distance = 0;

        while (x < 99) {
            // 왼쪽으로 이동
            if (y > 0 && arr[x][y - 1] == 1) {
                while (y > 0 && arr[x][y - 1] == 1) {
                    y--;
                    distance++;
                }
            }
            // 오른쪽으로 이동
            else if (y < 99 && arr[x][y + 1] == 1) {
                while (y < 99 && arr[x][y + 1] == 1) {
                    y++;
                    distance++;
                }
            }
            // 아래로 이동
            x++;
            distance++;
        }

        return distance;
    }
}