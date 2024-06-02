package simulation;
import java.io.*;
import java.util.*;
public class B3_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 1~n번 바구니
        int [] arr = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for(int j=first; j<=end; j++) {
                arr[j] = ball;
            }
        }
        for(int i=1; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
