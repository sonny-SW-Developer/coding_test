package chap4;
import java.util.*;
public class ex4_3 {
    public static void main(String[] args) {
        int[] oneRow = {1,1,-1,-1};
        int[] oneCol = {2,-2,2,-2};
        int[] twoRow = {-2,-2,2,2};
        int[] twoCol = {-1,1,-1,1};

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int col = s.charAt(0) - 'a' + 1;
        int row = s.charAt(1) - '0';
        int answer = 0;
        // 첫번째 함수 실행
        for(int i=0; i<4; i++) {
            int nx = row + oneRow[i];
            int ny = col + oneCol[i];
            if(nx <= 1 && nx <= 8 && ny <= 1 && ny <= 8) {
                answer++;
            }
        }

        for (int i=0; i<4; i++) {
            int nx = row + twoRow[i];
            int ny = col + twoCol[i];
            if(nx <= 1 && nx <= 8 && ny <= 1 && ny <= 8) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
