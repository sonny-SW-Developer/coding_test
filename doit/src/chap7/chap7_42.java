package chap7;
import java.io.*;
import java.util.*;

// 최소공배수 구하기 - 백준 1934(S5)
public class chap7_42 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = a*b / gcd(a,b);
            System.out.println(result);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
