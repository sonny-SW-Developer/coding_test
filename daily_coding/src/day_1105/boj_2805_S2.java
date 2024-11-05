package day_1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int index=0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(m, arr));
    }

    static int binarySearch(int m, int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr[arr.length-1];
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int height : arr) {
                if (height > mid) {
                    sum += height - mid;
                }
            }

            if(sum >= m) {
                result = mid;
                start = mid +1;
            } else if (sum < m) {
                end = mid-1;
            }
        }
        return result;
    }
}
