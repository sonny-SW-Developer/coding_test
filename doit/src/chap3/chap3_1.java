package chap3;
import java.util.*;

// 숫자 합 구하기 - 백준 11720(B2)
public class chap3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String numbers = sc.next();
        char[] cNum = numbers.toCharArray();

        int sum = 0;
        for(int i=0; i< cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
