import java.util.*;
import java.io.*;

// Test 문제 풀이 공간
public class Main {
    static int n;
    public static void main(String[] args) {
//        System.out.println("do it 프로그래밍 코딩테스트 자바편");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int end = 1;
        for(int i=0; i<n; i++) {
            end *= 10;
        }

        for (int i=end/10; i<end; end++) {
            DFS(i);
        }
    }

    static void DFS(int n) {
        if(n / 10 != 0) {
            DFS(n);
        }
    }
}