package chap7;
import java.io.*;
import java.util.*;

// 최대 공약수 구하기 - 백준 1850(S2)
public class chap7_43 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long result = gcd(a,b);
        while(result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
