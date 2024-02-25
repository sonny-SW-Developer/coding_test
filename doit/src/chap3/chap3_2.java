package chap3;
import java.util.*;

// 평균구하기 - 백준 1556(B1)
public class chap3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i< num; i++) {
            arr[i] = sc.nextInt();
        }

        double sum = 0;
        double max = Double.MIN_VALUE;
        for (int i = 0; i< num; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
        }
        System.out.println(sum / max / num * 100.0);
    }
}
