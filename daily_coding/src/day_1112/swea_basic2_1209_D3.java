package day_1112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_basic2_1209_D3 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            // 행 합 최대
            int rowSum = 0;
            // 열 합 최대
            int colSum = 0;
            // 왼 대각선 최대
            int leftLine = 0;
            // 오른 대각선 최대
            int rightLine = 0;

            // 행 최대 구하기
            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum=0;
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum += arr[i][j];
                }
                rowSum = Math.max(rowSum, sum);
            }

            // 열 최대 구하기
            for(int j=0; j<100; j++) {
                int sum=0;
                for(int i=0; i<100; i++) {
                    sum+= arr[i][j];
                }
                colSum = Math.max(colSum, sum);
            }

            // 왼쪽 대각선 최대 구하기
            for(int i=0; i<100; i++) {
                leftLine += arr[i][i];
                rightLine += arr[i][99-i];
            }

            int maxLine = Math.max(leftLine, rightLine);
            int maxLine2 = Math.max(rowSum, colSum);
            sb.append("#" + n + " ").append(Math.max(maxLine, maxLine2)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
