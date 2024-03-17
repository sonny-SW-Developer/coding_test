package chap4;
import java.util.*;
import java.io.*;

// 수 정렬하기 - 백준 2751(S5)
public class chap4_20 {
    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        A = new int[n+1];
        tmp = new int[n+1];

        for(int i=1; i<=n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void merge_sort(int start, int end) {
        if (end - start < 1) return;
        int middle = start + (end - start) / 2;
        // 재귀 형태
        merge_sort(start, middle);
        merge_sort(middle+1, end);
        for(int i=start; i<= end; i++) {
            tmp[i] = A[i];
        }

        int k = start;
        int i1 = start;
        int i2 = middle + 1;
        while(i1 <= middle && i2 <= end) {
            if(tmp[i1] > tmp[i2]) {
                A[k] = tmp[i2];
                k++;
                i2++;
            } else {
                A[k] = tmp[i1];
                k++;
                i1++;
            }
        }

        while(i1 <= middle) {
            A[k] = tmp[i1];
            k++;
            i1++;
        }

        while(i2 <= end) {
            A[k] = tmp[i2];
            k++;
            i2++;
        }
    }
}
