package day_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_20300_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long maxValue = 0;
        if(arr.length % 2 == 0) {
            for(int i=0; i<arr.length / 2; i++) {
                maxValue = Math.max(maxValue, arr[i] + arr[n-1-i]);
            }
        } else {
            maxValue = arr[arr.length-1];
            for(int i=0; i<(n-1)/2; i++) {
                maxValue = Math.max(maxValue, arr[i] + arr[n-2-i]);
            }
        }
        System.out.println(maxValue);
    }
}
