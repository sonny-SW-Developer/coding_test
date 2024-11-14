package day_1113;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_basic3_1215_D3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int num = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];

            // 정보 저장
            for (int i = 0; i < 8; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int count = 0;
            // 가로 회문 탐색
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - num; j++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < num / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + num - 1 - k]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) count++;
                }
            }

            // 세로 회문 탐색
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i <= 8 - num; i++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < num / 2; k++) {
                        if (arr[i + k][j] != arr[i + num - 1 - k][j]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) count++;
                }
            }
            sb.append("#" + tc + ": ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
