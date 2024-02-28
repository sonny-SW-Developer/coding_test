package chap3;
import java.util.*;
import java.io.*;

// 나머지 합 구하기 - 백준 10986(G3)
public class chap3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        S[0] = sc.nextInt();
        for (int i=1; i<N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            int remain = (int) (S[i] % M);
            if(remain == 0) answer++;
            C[remain]++;
        }

        for(int i=0; i<M; i++) {
            if(C[i] > 1) {
                answer = answer + (C[i] * (C[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}
