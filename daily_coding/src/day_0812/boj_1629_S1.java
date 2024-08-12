package day_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1629_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(solution(A,B,C));
    }

    static long solution(int a, int b, int c) {
        // A^B % C 연산
        if(b==0) return 1;
        // 모듈러 연산으로 실행해줘야 함.
        // Math.pow()방식을 이용하여 풀이하게 되면,
        // 이는 double형이라 매우 큰 값인 경우 정확도가 떨어질 수 있으며,
        // 부동소수점 연산을 수행하기 때문에 정확한 연산을 수행하지 못할 수 있음.
        long half = solution(a,b/2, c);
        long result = (half * half) % c;

        // B가 홀수인 경우
        if(b % 2 != 0) {
            result = (result * a) % c;
        }
        return result;
    }
}
