package day_1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_basic2_1210_D4 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=10; tc++) {
            int num = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 도착점 (2) 찾기
            int targetY = 0;
            for (int i = 0; i < 100; i++) {
                if (arr[99][i] == 2) {
                    targetY = i;
                    break;
                }
            }

            // 도착점에서 역방향으로 올라가기
            int x = 99, y = targetY;
            while (x > 0) {
                // 왼쪽 이동
                if (y > 0 && arr[x][y - 1] == 1) {
                    while (y > 0 && arr[x][y - 1] == 1) {
                        y--;
                    }
                }
                // 오른쪽 이동
                else if (y < 99 && arr[x][y + 1] == 1) {
                    while (y < 99 && arr[x][y + 1] == 1) {
                        y++;
                    }
                }
                // 위로 이동
                x--;
            }

            sb.append("#").append(num).append(" ").append(y).append("\n");
        }
        System.out.println(sb.toString());
    }
}
