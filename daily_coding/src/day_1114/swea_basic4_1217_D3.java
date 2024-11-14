package day_1114;
import java.util.Scanner;
public class swea_basic4_1217_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int num = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 1;
            for(int i=0; i<m; i++) {
                answer *= n;
            }
            System.out.println("#" + num + " "  + answer);
        }
    }
}
