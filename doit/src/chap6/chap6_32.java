package chap6;
import java.util.*;
import java.io.*;

// 동전 개수의 최솟값 구하기 - 백준 11047(S3)
public class chap6_32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        int money = k;
        for(int i = arr.length - 1; i>=0; i--) {
            if(arr[i] > money) {
                continue;
            }
            // 나누어 떨어질 때
            if(money == 0) {
                break;
            } else {
                // 나누어떨어지지 않을 때
                answer = answer + money / arr[i];
                money = money - (money / arr[i] * arr[i]);
//                System.out.println("i=" + i + "일 때, money=" + money + ", answer=" + answer);
            }
        }
        System.out.println(answer);
    }
}
