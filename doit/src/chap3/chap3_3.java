package chap3;
import java.util.*;
import java.io.*;

// 구간 합 구하기 4 - 백준 11659(S3)
public class chap3_3 {
    // Scanner 이용해서 풀이
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int i;
//        int num = sc.nextInt();
//        int countSum = sc.nextInt();
//        int[] arr = new int[num + 1];
//        int[] sumArr = new int[num + 1];
//
//        for(i = 1; i <= num; i++) {
//            arr[i] = sc.nextInt();
//            if (i == 1) {
//                sumArr[i] = arr[i];
//            } else {
//                sumArr[i] = sumArr[i-1] + arr[i];
//            }
//            System.out.println("sumArr[" + i + "] : " + sumArr[i]);
//        }
//
//        for (i= 0; i < countSum; i++) {
//            int first = sc.nextInt() - 1;
//            int last = sc.nextInt();
//            System.out.println(sumArr[last] - sumArr[first]);
//        }
//    }

    // BufferedReader 이용해서 풀이
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int countSum = Integer.parseInt(st.nextToken());

        long[] arr = new long[num + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<= num; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i=0; i< countSum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            System.out.println(arr[last] - arr[first - 1]);
        }
    }
}
