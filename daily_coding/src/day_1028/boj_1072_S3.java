package day_1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1072_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long x = Long.parseLong(st.nextToken());
        Long y = Long.parseLong(st.nextToken());

        int z = (int) (y * 100 / x);

        // 100%는 절대 될 수 없음
        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long start = 1;
        long end = x;
        long answer = -1;

        // 이분 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            int newRate = (int) ((y + mid) * 100 / (x + mid));

            if (newRate > z) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
