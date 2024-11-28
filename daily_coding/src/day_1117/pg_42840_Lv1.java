package day_1117;
import java.util.*;

public class pg_42840_Lv1 {
    // 완전탐색 - 모의고사
    // https://school.programmers.co.kr/learn/courses/30/lessons/42840
    static int[] solution(int[] answers) {
        int len = answers.length;
        int[] nums = new int[] {1,3,4,5};
        int[] one = new int[len];
        int[] two = new int[len];
        int[] three = new int[len];
        int[] corrects = new int[3];
        ArrayList<Integer> list = new ArrayList<>();

        int idx = 0;
        for(int i=0; i<len; i++) {
            // 1번 수포자
            one[i] = i % 5 + 1;

            // 2번 수포자
            if(i%2 == 0) two[i] = 2;
            else two[i] = nums[(idx++) % 4];

            // 3번 수포자
            if(i%10 <= 1) three[i] = 3;
            else if (i % 10 <=3) three[i] = 1;
            else if (i % 10 <=5) three[i] = 2;
            else if (i % 10 <=7) three[i] = 4;
            else three[i] = 5;
        }

        for(int i=0; i<len; i++) {
            if(answers[i] == one[i]) {
                corrects[0]++;

            } if (answers[i] == two[i]) {
                corrects[1]++;
            } if (answers[i] == three[i]) {
                corrects[2]++;
            }
        }

        for(int i=0; i<3; i++) {
            if(list.isEmpty()) {
                list.add(i);
            } else {
                // 최댓값이 더 큰 경우
                if(corrects[list.get(0)] > corrects[i]) continue;
                if(corrects[list.get(0)] < corrects[i]) {
                    list.clear();
                }
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i) + 1;
        }

        return answer;
    }
}
