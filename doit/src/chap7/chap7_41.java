package chap7;
import java.util.*;
import java.io.*;
public class chap7_41 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        // 제곱근까지만 진행
        for(long i=2; i<=Math.sqrt(n); i++) {
            // p가 소인수인지 확인.
            if(n % i == 0) {
                // 소인수가 아니라면 값 업데이트
                result = result - result/i;
                while(n % i == 0) {
                    // 2의 7제곱 * 11이라면 2의 7제곱을 없애고 11만 남김.
                    n /= i;
                }
            }
        }

        if(n>1) {
            result = result - result/n;
        }
        System.out.println(result);
    }
}
