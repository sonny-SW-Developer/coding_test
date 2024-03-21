package chap6;
import java.util.*;
import java.io.*;

// 회의실 배정하기 - 백준 1931(S1)
public class chap6_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] s, int[] e) {
                // 종료 시간이 같을 때는 시작 시간 우선으로 정렬
                if(s[1] == e[1]) {
                    return s[0] - e[0];
                }
                return s[1] - e[1];
            }
        });

        int count = 0;
        int end = -1;
        for(int i=0; i<n; i++) {
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
