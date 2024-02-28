package chap3;
import java.util.*;
import java.io.*;

// 구간 합 구하기 2 - 백준 11660(S1)
public class chap3_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 표의 크기
        int N = Integer.parseInt(st.nextToken());
        // 구해야하는 횟수
        int M = Integer.parseInt(st.nextToken());
        long[][] arr = new long[N+1][N+1];
        long[][] sumArr = new long[N+1][N+1];

        for (int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] + sumArr[i-1][j-1] + arr[i][j];
            }
        }

        for (int i=1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long result = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
