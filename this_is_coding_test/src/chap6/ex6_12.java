package chap6;
import java.util.*;
import java.io.*;

public class ex6_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] A = new Integer[n];
        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        Integer[] B = new Integer[n];
        for(int i=0; i<n; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            if(A[i] < B[i]) {
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            }
            else break;
        }

        long result = 0;
        for(int i=0; i<n; i++) {
            result+= A[i];
        }
        System.out.println(result);
    }
}
