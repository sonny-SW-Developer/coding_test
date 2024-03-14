package chap4;
import java.io.*;
import java.util.*;

// 수 정렬하기(버블 정렬) - 백준 2750(B1)
public class chap4_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for(int i=0; i<n; i++) {
            for (int j=0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }
}
