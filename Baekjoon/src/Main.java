import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        A = new int[n];
        result = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int total = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        solution(total);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<result.length; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }
        System.out.println(max);
    }

    static void solution(int num) {
       int avg = num / A.length;
       int underSum = 0, underCnt=0;
       for(int i=0; i<A.length; i++) {
           if(A[i] <= avg) {
               result[i] = A[i];
               underSum += result[i];
               underCnt++;
           }
       }
       int sum = num - underSum;
       int upperAvgVal = sum / (A.length - underCnt);
        for(int i=0; i<A.length; i++) {
            if(result[i] == 0) {
                if(A[i] >= upperAvgVal) result[i] = upperAvgVal;
                else result[i] = A[i];
            }
        }
    }
}