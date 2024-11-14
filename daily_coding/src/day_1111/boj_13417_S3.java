package day_1111;
import java.util.*;
import java.io.*;
public class boj_13417_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            char[] arr = new char[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index=0;
            while(st.hasMoreTokens()) {
                arr[index++] = st.nextToken().charAt(0);
            }
            String answer = arr[0] + "";
            for(int i=1; i<arr.length; i++) {
                char c = arr[i];
                if(c <= answer.charAt(0)) {
                    answer = c + answer;
                } else {
                    answer = answer + c;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
