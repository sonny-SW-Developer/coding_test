package chap6;
import java.io.*;
import java.util.*;

// 카드 정렬하기 - 백준 1715(G4)
public class chap6_33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        int num1 = 0;
        int num2 = 0;
        int sum = 0;

        while(pq.size() != 1) {
            num1 = pq.remove();
            num2 = pq.remove();
            sum += num1 + num2;
            pq.add(num1+ num2);
        }
        System.out.println(sum);
    }
}
