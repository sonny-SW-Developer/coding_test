package implementation;
import java.util.*;
import java.io.*;

// 줄 세우기
public class bj_10431_s5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int P = sc.nextInt();
        int[] arr = new int[21];

        for (int i=0; i<P; i++) {
            int answer = 0;
            sb.append(sc.nextInt() + " ");
            for (int j=1; j<=20; j++) {
                arr[j] = sc.nextInt();
                for (int k=1; k<j; k++) {
                    if(arr[k] > arr[j]) {
                        answer++;
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
