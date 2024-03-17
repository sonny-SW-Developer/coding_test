import java.util.List;

// Test 문제 풀이 공간
public class Main {
    public static void main(String[] args) {
        System.out.println("do it 프로그래밍 코딩테스트 자바편");
    }

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = new int[privacies.length];
            String[] list = today.split(".");
            int todayYear = Integer.parseInt(list[0]);
            int todayMonth = Integer.parseInt(list[1]);
            int todayDay = Integer.parseInt(list[2]);

            // 개인정보 개수만큼 반복
            for (int i=0; i<privacies.length; i++) {
                String[] privacyInfo = privacies[i].split(" ");
                // 만료 달 정보 가져온다.
                int endMonth = getMonth(privacyInfo[1], terms);
                String[] infoList = privacyInfo[0].split(".");
                // 개인정보 동의 날짜
                int year = Integer.parseInt(infoList[0]);
                int month = Integer.parseInt(infoList[1]);
                int day = Integer.parseInt(infoList[2]);

                if(endMonth + month > 12) {
                    year +=1;
                    month =endMonth + month - 12;
                }
                if (day-1 == 0) {

                }

            }
            return answer;
        }

        public int getMonth(String info, String[] terms) {
            for(int j=0; j<terms.length; j++) {
                if(terms[j].contains(info)) {
                    String[] list = terms[j].split(" ");
                    return Integer.parseInt(list[1]);
                }
            }
            return 0;
        }
    }
}