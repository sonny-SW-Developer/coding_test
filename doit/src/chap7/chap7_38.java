package chap7;
import java.util.*;
import java.io.*;

// 거의 소수 구하기 - 백준 1456(S1)
public class chap7_38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long[] arr = new long[10000001];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i=2; i<=Math.sqrt(arr.length); i++) {
            if(arr[i]==0) continue;
            for(int j= i+i; j<arr.length; j= j+i) {
                arr[j] = 0;
            }
        }

        int count = 0;
        for(int i=2; i< 10000001; i++) {
            if(arr[i] != 0) {
                long temp = arr[i];
                while((double)arr[i] <= (double)max / (double)temp) {
                    if((double)arr[i] >= (double)min / (double)temp) {
                        count++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
        System.out.println(count);
    }
}
