package chap7;
import java.util.*;

// 이진 탐색 - 부품 찾기
public class ex7_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] find = new int[m];
        for(int i=0; i<m; i++) {
            find[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            // 이진 탐색 구현
            boolean result = binarySearch(arr, find[i], 0, n-1);
            if(!result) sb.append("no ");
            else sb.append("yes ");
        }

        System.out.println(sb.toString());
    }

    static boolean binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return false;
        int mid = (start + end) / 2;
        if(arr[mid] == target) return true;
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid-1);
        else return binarySearch(arr, target, mid+1, end);
    }
}
