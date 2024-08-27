package day_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_S5 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();
        solution(arr, arr2);
        System.out.println(sb.toString());
    }

    static void solution(int[] arr, int[] arr2) {
        for(int i=0; i<arr2.length; i++) {
            if(binarySearch(0, arr.length-1, arr, arr2[i])) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
    }

    static boolean binarySearch(int start, int end, int[] arr, int target) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid +1;
            } else {
                end = mid-1;
            }
        }

        return false;
    }
}
