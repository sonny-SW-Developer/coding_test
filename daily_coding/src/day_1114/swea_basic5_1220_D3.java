package day_1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_basic5_1220_D3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            // 각 열(column)을 탐색하면서 교착 상태를 체크
            for (int j = 0; j < 100; j++) {
                boolean redEncountered = false; // N극(1)을 만났는지 여부
                for (int i = 0; i < 100; i++) {
                    if (arr[i][j] == 1) {
                        redEncountered = true; // N극을 만남
                    } else if (arr[i][j] == 2) {
                        if (redEncountered) {
                            // N극(1)을 만난 이후 S극(2)을 만나면 교착 상태 발생
                            count++;
                            redEncountered = false; // 다시 초기화
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
