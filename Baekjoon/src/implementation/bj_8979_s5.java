package implementation;
import java.util.*;
import java.io.*;

// 올림픽
public class bj_8979_s5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][3];
        int result = 1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr[value][0] = gold;
            arr[value][1] = silver;
            arr[value][2] = bronze;
        }

        for(int i=1; i<=n; i++) {
            if (arr[i][0] > arr[k][0]) {
                result++;
            } else if (arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) {
                result++;
            } else if (arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
