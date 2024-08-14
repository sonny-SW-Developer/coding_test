package day_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654_S2 {
    static int k;
    static long n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Long.parseLong(st.nextToken());
        long max = 0;
        arr = new long[k];
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        solution(1, max);
    }

    static void solution(long start, long end) {
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            int total = 0;
            for(int i=0; i<arr.length; i++) {
                total += (arr[i] / mid);
            }
            // 개수 채우지 못하는 경우
            if(total < n) {
                end = mid-1;
            } else {
                // 개수를 채운 경우
                answer = mid;
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
