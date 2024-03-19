package chap5;
import java.io.*;
import java.util.*;

// 원하는 정수 찾기 - 백준 1920(S4)
public class chap5_29 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        // M개 글자 출력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean find = false;
            int start = 0;
            int end = arr.length - 1;
            while(start <= end) {
                int mid = (start+end) / 2;
                if(arr[mid] > num) {
                    end = mid-1;
                } else if (arr[mid] < num) {
                    start = mid+1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
