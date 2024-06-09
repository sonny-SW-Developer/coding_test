package chap7;
import java.util.*;

// 떡볶이 떡 만들기
public class ex7_8 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<4; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        binarySearch(arr, h, 0, arr[arr.length - 1]);
        System.out.println(result);
    }

    static void binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return;
        int mid = (start + end) / 2;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > mid) sum += arr[i] - mid;
        }

        if(sum < target) {
            binarySearch(arr, target, start, mid-1);
        } else {
            result = mid;
            binarySearch(arr, target, mid+1, end);
        }
    }
}
