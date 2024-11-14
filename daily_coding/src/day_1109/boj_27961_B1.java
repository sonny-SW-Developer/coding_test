package day_1109;
import java.io.*;
import java.util.*;
public class boj_27961_B1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N == 0) {
            System.out.print(0);
            return;
        }

        long cnt = 1;
        long sum = 1;
        while (sum < N) {
            sum *= 2;
            cnt++;
        }

        System.out.print(cnt);

    }
}
