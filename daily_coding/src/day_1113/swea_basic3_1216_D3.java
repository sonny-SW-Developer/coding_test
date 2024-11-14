package day_1113;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_basic3_1216_D3 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int testCaseNum = Integer.parseInt(br.readLine());
            char[][] board = new char[100][100];
            // 글자판 입력
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int maxLength = 1; // 최소 회문의 길이는 1

            // 가로 방향 회문 검사
            for (int i = 0; i < 100; i++) {
                for (int start = 0; start < 100; start++) {
                    for (int end = 99; end >= start; end--) {
                        if (isPalindromeRow(i, start, end, board)) {
                            maxLength = Math.max(maxLength, end - start + 1);
                            break; // 더 긴 회문을 찾았으므로 이 구간은 탐색 종료
                        }
                    }
                }
            }

            // 세로 방향 회문 검사
            for (int j = 0; j < 100; j++) {
                for (int start = 0; start < 100; start++) {
                    for (int end = 99; end >= start; end--) {
                        if (isPalindromeCol(j, start, end, board)) {
                            maxLength = Math.max(maxLength, end - start + 1);
                            break; // 더 긴 회문을 찾았으므로 이 구간은 탐색 종료
                        }
                    }
                }
            }

            sb.append("#").append(testCaseNum).append(" ").append(maxLength).append("\n");
        }
        System.out.print(sb.toString());
    }

    // 가로 방향 회문 검사
    static boolean isPalindromeRow(int row, int start, int end, char[][] board) {
        while (start < end) {
            if (board[row][start] != board[row][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 세로 방향 회문 검사
    static boolean isPalindromeCol(int col, int start, int end, char[][] board) {
        while (start < end) {
            if (board[start][col] != board[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
