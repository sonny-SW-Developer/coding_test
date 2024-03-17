package chap4;
import java.io.*;
import java.util.*;

// 버블 소트 프로그램2 - 백준 1517(P5)
public class chap4_21 {
    public static int[] arr, tmp;
    public static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        tmp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(1, n);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if(end - start < 1) {
            return ;
        }

        int middle = start + (end - start) / 2;
        mergeSort(start, middle);
        mergeSort(middle+1, end);
        for(int i=start; i<= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start;
        int i1 = start;
        int i2 = middle + 1;
        while (i1 <= middle && i2 <= end) {
            if(tmp[i1] > tmp[i2]) {
                arr[k] = tmp[i2];
                result = result + i2 - k;
                k++;
                i2++;
            } else {
                arr[k] = tmp[i1];
                k++;
                i1++;
            }
        }

        while(i1 <= middle) {
            arr[k] = tmp[i1];
            k++;
            i1++;
        }
        while (i2 <= end) {
            arr[k] = tmp[i2];
            k++;
            i2++;
        }
    }

}
