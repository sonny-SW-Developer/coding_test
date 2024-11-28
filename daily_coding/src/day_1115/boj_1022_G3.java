package day_1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1022_G3 {
    static int x1, y1, x2, y2, max = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        map = new int[x2 - x1 + 1][y2 - y1 + 1];
        writeMap();
        printResult();
    }

    private static void writeMap() {
        int x = 0, y = 0, dir = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!isFinish()) {
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                map[x - x1][y - y1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if (cnt == dnum) {
                cnt = 0;
                if (dir == 1 || dir == 3) dnum++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    private static void printResult() {
        int maxLen = (int) Math.log10(max), len;

        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                len = maxLen - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isFinish() {
        return map[0][0] != 0 && map[x2 - x1][0] != 0 && map[0][y2 - y1] != 0 && map[x2 - x1][y2 - y1] != 0;
    }
}
