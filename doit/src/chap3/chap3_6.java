package chap3;
import java.util.*;
import java.io.*;

// 연속된 자연수의 합 구하기 - 백준 2018(S5)
// 투 포인터 개념 활용
public class chap3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

        while(end != N) {
            if (sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
