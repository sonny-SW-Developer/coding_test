package chap4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ex4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = 1;
        int y = 1;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            char c = st.nextToken().charAt(0);
            // 왼쪽으로 이동하는 경우
            if (c == 'L' && y >= 2) {
                y--;
            } else if (c == 'U' && x >= 2) {
                x--;
            } else if (c == 'R' && y <= n-1) {
                y++;
            } else if (c == 'D' && x <= n-1) {
                x++;
            }
        }
        System.out.println(x + " " + y);
    }
}
