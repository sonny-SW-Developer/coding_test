package day_1105;

import java.util.HashMap;
import java.util.Map;

// 문제 link : https://school.programmers.co.kr/learn/courses/30/lessons/77486
public class pg_77486_l3 {
    static int[] answer;
    static Map<String, Integer> nameIndexMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        answer = new int[len];

        for (int i = 0; i < len; i++) {
            nameIndexMap.put(enroll[i], i);
        }

        for(int i=0; i<seller.length; i++) {
            String person = seller[i];
            DFS(person, amount[i] * 100, enroll, referral);
        }


        return answer;
    }

    static void DFS(String person, int amount, String[] enroll, String[] referral) {
        if (amount == 0) return;

        // 해당 사람의 인덱스 찾기
        int index = nameIndexMap.get(person);

        // 배분할 금액 계산
        int left = amount / 10;
        answer[index] += amount - left;

        // 추천인 있을 때만 DFS 수행
        if (!referral[index].equals("-")) {
            DFS(referral[index], left, enroll, referral);
        }
    }
}
