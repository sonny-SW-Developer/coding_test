package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1417_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        while(true) {
            int maxIndex = -1;
            int maxVal = -1;
            for(int i=0; i<num; i++) {
                if(maxVal <= arr[i]) {
                    maxVal = arr[i];
                    maxIndex = i;
                }
            }

            if(maxIndex == 0) break;
            arr[0]++;
            arr[maxIndex]--;
            answer++;
        }
        System.out.println(answer);
    }
}
