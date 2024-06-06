package chap3;
import java.util.*;

public class ex3_1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int five_count = N / 500;
//        N = N - five_count * 500;
//        int hundred_count = N / 100;
//        N = N - hundred_count * 100;
//        int fifty_count = N / 50;
//        N = N - fifty_count * 50;
//        int ten_count = N / 10;
//        System.out.println(five_count + hundred_count + fifty_count + ten_count);
//    }

    /// 모범 답안
    public static void main(String[] args) {
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
    }
}
