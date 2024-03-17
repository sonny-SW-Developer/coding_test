package chap4;
import java.util.*;
import java.io.*;

// ATM인출 시간 계산하기 - 백준 11399(S3)
public class chap4_18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 정렬된 배열
        int[] A = new int[n];
        // 정렬된 배열의 합 배열
        int[] S = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입정렬 구현
        for(int i=1; i<n; i++) {
            int index = i;
            int value = A[i];

            for(int j = i-1; j>=0; j--) {
                if(A[j] < A[i]) {
                    index = j+1;
                    break;
                }
                if(j==0) {
                    index = 0;
                }
            }

            for(int j=i; j>index; j--) {
                A[j] = A[j-1];
            }
            A[index] = value;

            System.out.print("A 배열은 i가 " + i + "일 때, ");
            // 배열 구해보기
            for(int t=0; t<n; t++) {
                System.out.print(A[t] + " ");
            }
            System.out.println(" ");

            S[0] = A[0];
            for(int t=1; t<n; t++) {
                S[t] = S[t-1] + A[t];
            }

            System.out.print("S 배열 : ");
            // 배열 구해보기
            for(int t=0; t<n; t++) {
                System.out.print(S[t] + " ");
            }
            System.out.println(" ");
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }
}
