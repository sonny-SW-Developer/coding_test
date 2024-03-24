package chap7;
import java.util.*;
import java.io.*;

// 제곱이 아닌 수 찾기 - 백준 1016(G1)
public class chap7_40 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 최댓값과 최솟값의 차이만큼 배열 선언
        boolean[] check = new boolean[(int) (max-min+1)];
        for(long i=2; i*i <= max; i++) {
            long pow = i*i;
            long start_index = min / pow;
            if(min % pow != 0) {
                start_index++;
            }
            for(long j=start_index; pow * j <= max; j++) {
                check[(int) ((j*pow) - min)] = true;
            }
        }

        int count = 0;
        for(int i=0; i<= max-min; i++) {
            if(!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
