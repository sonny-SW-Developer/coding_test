package chap6;
import java.io.*;
import java.util.*;

// 최솟값을 만드는 괄호 배치 찾기 - 백준 1541(S2)
public class chap6_36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        String temp = st.nextToken();
        int num=0;
        int sum=0;
        // 100-40+50+74-30+29-45+43+11

        while(st.hasMoreTokens()) {
            String number = st.nextToken();
            if(number.contains("+")) {
                StringTokenizer st2 = new StringTokenizer(number, "+");
                while(st2.hasMoreTokens()) {
                    sum += Integer.parseInt(st2.nextToken());
                }
            } else {
                sum += Integer.parseInt(number);
            }
        }

        if(temp.contains("+")) {
            st = new StringTokenizer(temp, "+");
            while(st.hasMoreTokens()) {
                num += Integer.parseInt(st.nextToken());
            }
        } else {
            num = Integer.parseInt(temp);
        }
        System.out.println(num - sum);
    }
}
