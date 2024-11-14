package day_1112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea_basic1_1208_D3 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<dump; i++) {
                Arrays.sort(arr);
                int diff = arr[99] - arr[0];
                if(diff <= 1) break;
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            sb.append("#" + test_case + " ").append(arr[99] - arr[0]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
