package chap7;
import java.util.*;
import java.io.*;

// 소수 & 팰린드롬 수 중에서 최솟값 찾기 - 백준 1747(G5)
public class chap7_39 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i=2; i<Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) continue;
            for(int j=2*i; j< arr.length; j=j+i) {
                arr[j] = 0;
            }
        }

        int i = n;
        while(true) {
            if(arr[i] != 0) {
                if(isPalindrome(arr[i])) {
                    System.out.println(arr[i]);
                    break;
                }
            }
            i++;
        }
    }

    static boolean isPalindrome(int num) {
        char temp[] = String.valueOf(num).toCharArray();
        int s = 0;
        int e = temp.length -1;
        while(s<e) {
            if(temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
//        String str = String.valueOf(num);
//        int length = str.length();
//        for(int i=0; i<= length / 2; i++) {
//            if(str.charAt(i) != str.charAt(length-i-1)) {
//                return false;
//            }
//        }
//        return true;
    }
}
