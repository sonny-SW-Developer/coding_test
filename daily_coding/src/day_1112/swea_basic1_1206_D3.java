package day_1112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_basic1_1206_D3 {
    public static void main(String args[]) throws Exception
    {
        // System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;

            for(int i=2; i<num-2; i++) {
                int curHeight = arr[i];
                int maxLeftHeight = Math.max(arr[i-1], arr[i-2]);
                int maxRightHeight = Math.max(arr[i+1], arr[i+2]);
                int maxHeight = Math.max(maxLeftHeight, maxRightHeight);
                if(curHeight > maxHeight) {
                    cnt += (curHeight - maxHeight);
                } else {
                    continue;
                }
            }
            sb.append("#" + test_case + " ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
