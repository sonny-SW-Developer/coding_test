package day_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1083_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < input && s > 0; i++) {
            // 교환할 수 있는 최대 범위 설정
            int maxIndex = i;
            for (int j = i + 1; j < input && j <= i + s; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 선택된 maxIndex의 값을 앞으로 가져옴
            for (int j = maxIndex; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                s--;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
