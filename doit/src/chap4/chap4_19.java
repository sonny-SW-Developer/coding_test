package chap4;
import java.io.*;
import java.util.*;

// K번째 수 구하기 - 백준 11004(S5)
public class chap4_19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }

    public static void quickSort(int[] A, int s, int e, int k) {
        if (s < e) {
            int pivot = partition(A, s, e);
            if(pivot == k) return;
            else if (k < pivot) quickSort(A, s, pivot-1, k);
            else quickSort(A, pivot+1, e, k);
        }
    }

    public static int partition(int[] A, int start, int end) {
        if(start + 1 == end) {
            if(A[start] > A[end]) swap(A, start, end);
            return end;
        }

        int middle = (start + end ) / 2;
        swap(A, start, middle);
        int pivot = A[start];
        int i = start+1, j = end;
        while(i <= j) {
            while(j >= start + 1 && pivot < A[j]) {
                j--;
            }
            while(i <= end && pivot > A[j]) {
                i++;
            }
            if(i <= j) {
                swap(A, i++, j--);
            }
        }

        // 두 그룹의 경계 index에 피벗 데이터 저장.
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
