package day_1121;
import java.util.*;
public class pg_42626_Lv2 {
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static int solution(int[] scoville, int K) {
        int answer = 0;
        for(int num : scoville) {
            q.offer(num);
        }

        while(q.size() >= 2 && !check(K)) {
            int n1 = q.poll();
            int n2 = q.poll();
            q.offer(n1 + n2 * 2);
            answer++;
        }

        return check(K) ? answer : -1;
    }

    // 모두 넘어가면 true
    static boolean check(int K) {
        for(int num : q) {
            if(num < K) {
                return false;
            }
        }
        return true;
    }
}
