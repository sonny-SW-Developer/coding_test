package day_1120;
import java.util.*;
import java.io.*;
public class boj_2437_G2 {
    static int[] arr;
    static boolean[] isAvailable;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[num];
        visited = new boolean[num];

        int sum = 0;
        for(int i=0; i<num; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            sum += arr[i];
        }

        isAvailable = new boolean[sum+1];

        // 오름차순
        Arrays.sort(arr);

        // 백트래킹으로 조합 구하기
        backTrack(0, 0);
    }

    static void backTrack(int start, int total) {

        for(int i=start; i<arr.length; i++) {

        }
    }
}
