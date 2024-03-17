package chap4;
import java.io.*;
import java.util.*;

// 수 정렬하기 3 - 백준 10989(S5)
public class chap4_22 {
    public static int[] arr;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        radixSort(arr,5);
        for (int i=0; i<n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count=0;

        while (count != max_size) {
            int[] bucket = new int[10];
            for(int i=0; i<A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++;
            }
            for(int i=1; i<10; i++) {
                bucket[i] += bucket[i-1];
            }
            for (int i=A.length - 1; i>= 0; i--) {
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            for(int i=0; i<A.length; i++) {
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
