package chap4;
import java.util.*;
import java.io.*;

// 내림차순으로 자릿수 정렬하기 - 백준 1427(S5)
public class chap4_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        char c;
        int index=0;
        for (int i=0; i<arr.length; i++) {
            c = '0';
            for (int j=i; j<arr.length; j++) {
               if(c < arr[j]) {
                   c = arr[j];
                   index = j;
               }
            }
            if (arr[i] < arr[index]) {
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
//            System.out.println("i=" + i + "일 때, 배열 값은 다음과 같습니다.");
//            for (int k=0; k<arr.length; k++) {
//                System.out.print(arr[k] + " ");
//            }
//            System.out.println(" ");
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
