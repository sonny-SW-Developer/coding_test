package chap5;
import java.util.*;
import java.io.*;

// 배열에서 K번째 수 찾기
public class chap5_31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1, end = k;
        long answer = 0;

        // 이진 탐색 수행
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            // 중앙값보다 작은 수의 개수 계산하기
            for(int i=1; i<=n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if(cnt < k) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
