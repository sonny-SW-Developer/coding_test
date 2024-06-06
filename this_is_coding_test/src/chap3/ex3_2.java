package chap3;
import java.util.*;
import java.io.*;

public class ex3_2 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[arr.length-1];
        int second = arr[arr.length - 2];
        if (first == second) {
           answer = first * m;
        } else {
            for(int i=1; i<=m; i++) {
                if (i % (k+1) == 0) {
                    answer += second;
                } else {
                    answer += first;
                }
            }
        }
        System.out.println(answer);
    }
}
