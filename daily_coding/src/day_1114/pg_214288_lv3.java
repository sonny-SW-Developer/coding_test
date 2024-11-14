package day_1114;
import java.util.*;
public class pg_214288_lv3 {
    static ArrayList<int[]>[] consults;
    static int[] mentors;
    public int solution(int k, int n, int[][] reqs) {
        // 각 상담 유형별 멘토 수 저장
        mentors = new int[k + 1];
        Arrays.fill(mentors, 1);

        // 상담 요청 정보 저장
        consults = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            consults[i] = new ArrayList<>();
        }

        for (int[] req : reqs) {
            // {시작 시간, 상담 시간}
            consults[req[2]].add(new int[]{req[0], req[1]});
        }

        // 현재 상태에서의 대기 시간 계산
        int totalWaitTime = getTime(k);

        // 남은 멘토를 추가하면서 대기 시간 최적화
        for (int remainingMentors = n - k; remainingMentors > 0; remainingMentors--) {
            int bestReduction = 0;
            int bestType = -1;

            // 각 유형에 대해 멘토 1명을 추가했을 때의 대기 시간 감소 계산
            for (int type = 1; type <= k; type++) {
                mentors[type]++;
                int newWaitTime = getTime(k);
                int reduction = totalWaitTime - newWaitTime;
                if (reduction > bestReduction) {
                    bestReduction = reduction;
                    bestType = type;
                }
                // 원래 상태로 복원
                mentors[type]--;
            }

            // 가장 대기 시간 감소 효과가 큰 유형에 멘토 추가
            if (bestType != -1) {
                mentors[bestType]++;
                totalWaitTime -= bestReduction;
            }
        }

        return totalWaitTime;
    }

    private int getTime(int k) {
        int totalWaitTime = 0;

        for (int type = 1; type <= k; type++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < mentors[type]; i++) {
                pq.offer(0); // 초기 각 멘토의 상담 종료 시간을 0으로 설정
            }

            for (int[] req : consults[type]) {
                int startTime = req[0];
                int duration = req[1];
                int availableTime = pq.poll(); // 가장 빨리 상담이 끝나는 멘토
                int waitTime = Math.max(0, availableTime - startTime);
                totalWaitTime += waitTime;
                pq.offer(Math.max(startTime, availableTime) + duration); // 상담 종료 시간 갱신
            }
        }

        return totalWaitTime;
    }

    // 두번째 풀이 방법
    static class Solution2 {
        static int[] mentors;
        static ArrayList<Time>[] consultList;
        static int minTime = Integer.MAX_VALUE;

        public int solution(int k, int n, int[][] reqs) {
            // k : 상담 유형 수
            // n : 멘토 수
            // k <= n <= 20
            // reqs: 참가자 상담 요청 정보 (시각, 상담시간, 상담유형)

            mentors = new int[k+1];

            // 상담 정보 저장
            consultList = new ArrayList[k+1];
            for(int i=0; i<=k; i++) {
                consultList[i] = new ArrayList<>();
            }

            for(int[] info : reqs) {
                // 유형별 시작시간, 상담시간 저장
                consultList[info[2]].add(new Time(info[0], info[1]));
            }

            backTrack(1, k, n-k);
            return minTime;
        }

        // index: 상담 유형 의미
        static void backTrack(int index, int k, int remainMentors) {
            // 모든 상담 유형에 대한 멘토 배정이 완료된 경우
            if (index > k) {
                // 남은 멘토 수가 0인 경우에만 최소 대기 시간 갱신
                System.out.println("index:" + index + ", k: " + k + ", remainMentors: " + remainMentors);
                if (remainMentors == 0) {
                    minTime = Math.min(minTime, getWaitTime());
                }
                return;
            }

            // 현재 상담 유형에 최소 한 명의 멘토를 배정하기 위해 사용
            for(int i=1; i<=remainMentors+1; i++) {
                mentors[index] = i;
                for(int num : mentors) {
                    System.out.print(num + " ");
                }
                System.out.println();
                backTrack(index+1, k, remainMentors - (i-1));
            }
        }

        static int getWaitTime() {
            int totalWaitTime = 0;

            for (int type = 1; type < mentors.length; type++) {
                int mems = mentors[type];
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int i = 0; i < mems; i++) {
                    // 초기 각 멘토의 상담 종료 시간을 0으로 설정
                    pq.offer(0);
                }

                for (Time t : consultList[type]) {
                    int startTime = t.start;
                    int duration = t.end;
                    // 가장 먼저 끝나는 멘토의 상담 종료 시간
                    int availableTime = pq.poll();
                    // 대기 시간 계산
                    int waitTime = Math.max(0, availableTime - startTime);
                    totalWaitTime += waitTime;
                    // 상담 종료 시간 업데이트
                    pq.offer(Math.max(startTime, availableTime) + duration);
                }
            }

            return totalWaitTime;
        }

        static class Time {
            int start;
            int end;
            Time(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }
}
