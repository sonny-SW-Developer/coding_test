package chap6;
import java.io.*;
import java.util.*;

// 수를 묶어서 최댓값 만들기 - 백준 1744(G4)
public class chap6_34 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int one=0, zero = 0;
        // 양수는 내림차순 정렬하기
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) {
                plusQueue.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                minusQueue.add(num);
            }
        }

        int sum = 0;
        int num1, num2;
        // 양수 처리
        while(plusQueue.size() > 1) {
            num1 = plusQueue.remove();
            num2 = plusQueue.remove();
            sum += (num1 * num2);
        }
        if(!plusQueue.isEmpty()) {
            sum += plusQueue.remove();
        }

        // 음수 처리
        while(minusQueue.size() > 1) {
            num1 = minusQueue.remove();
            num2 = minusQueue.remove();
            sum += (num1 * num2);
        }
        if(!minusQueue.isEmpty()) {
            if(zero == 0) sum += minusQueue.remove();
        }

        sum += one;
        System.out.println(sum);
    }
}
