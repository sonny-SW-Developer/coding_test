package day_1114;
import java.util.*;
import java.io.*;

public class boj_2212_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 센서의 개수
        int K = Integer.parseInt(br.readLine()); // 집중국의 개수
        int[] sensors = new int[N];

        // 센서 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 집중국 개수가 센서보다 많으면 0
        if (K >= N) {
            System.out.println(0);
            return;
        }

        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 인접한 센서 간의 거리 차이 계산
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 차이를 내림차순 정렬
        Arrays.sort(distances);

        // 최소 거리 합 구하기
        int result = 0;
        // N-K = 4개
        for (int i = 0; i < N - K; i++) {
            result += distances[i];
        }

        System.out.println(result);
    }
}
