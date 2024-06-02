package dynamic_programming.D0602;
import java.util.*;
public class S3_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        int num = sc.nextInt();

        arr[0] = 0;
        arr[1] = 1; // {1}
        arr[2] = 2; // {2}, {1,1}
        arr[3] = 4; // {3}, {2,1}, {1,2}, {1,1,1}

        for(int i=0; i<num; i++) {
            int n = sc.nextInt();
            for(int j=4; j<=n; j++) {
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            System.out.println(arr[n]);
        }
    }
}
