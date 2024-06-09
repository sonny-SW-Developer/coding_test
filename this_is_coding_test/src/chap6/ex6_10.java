package chap6;
import java.util.*;
import java.io.*;

public class ex6_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // 방법1. 내림차순 정렬로 구현하기
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
//        // 방법 2. 오름차순 정렬 후 반대로 출력하기
//        int[] arr =  new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//        for(int i=arr.length-1; i>=0; i--) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
