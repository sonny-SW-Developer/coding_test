package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_G4 {
    static int n,c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        // 최소, 최대 간격
        int low = 1;
        int high = arr[n - 1] - arr[0];
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canPlaceRouters(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // mid 거리에 설치 가능 여부 확인
    private static boolean canPlaceRouters(int mid) {
        int lastPosition = arr[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPosition >= mid) {
                count++;
                lastPosition = arr[i];
            }
        }

        return count >= c;
    }
}
