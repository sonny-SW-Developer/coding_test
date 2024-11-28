package day_1127;

public class pg_150369_Lv2 {
    // 2023 카카오 기출문제 : 택배 배달과 수거하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/150369

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;
        // 마지막 집부터 차례대로 순회한다.
        for (int i = n - 1; i >= 0; i--) {
            // 물류창고 - 집까지 왕복한 횟수
            int cnt = 0;
            // 배달, 수거 작업
            d -= deliveries[i];
            p -= pickups[i];

            // 왕복할 때마다 cap만큼 상자를 더 실을 수 있으므로
            // 배달 상자 개수와 수거 상자 개수에 더한다.
            while (d < 0 || p < 0) {
                d += cap;
                p += cap;
                cnt++;
            }

            // 왕복 거리 계산
            answer += (i + 1) * 2 * cnt;
        }

        return answer;
    }
}
