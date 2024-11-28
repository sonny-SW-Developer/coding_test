package day_1125;

public class pg_150368_Lv2 {
    // 프로그래머스 2023 카카오 - 이모티콘 할인행사
    // https://school.programmers.co.kr/learn/courses/30/lessons/150368
    static int n, m;
    static int[] discounts = {10, 20, 30, 40};
    static int maxSubscribers = 0;
    static int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;

        // 할인율 조합
        combi(emoticons, users, new int[m], 0);

        // 최적 결과 반환
        return new int[]{maxSubscribers, maxSales};
    }

    // 할인율 조합 생성
    private void combi(int[] emoticons, int[][] users, int[] curDiscounts, int depth) {
        if (depth == m) {
            // 모든 할인율 조합 저장 시 계산 구현
            simulate(users, emoticons, curDiscounts);
            return;
        }

        for (int discount : discounts) {
            curDiscounts[depth] = discount;
            combi(emoticons, users, curDiscounts, depth + 1);
        }
    }

    // 사용자 구매 및 서비스 가입 시뮬레이션
    private void simulate(int[][] users, int[] emoticons, int[] currentDiscounts) {
        int subscribers = 0;
        int totalSales = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int priceThreshold = user[1];

            int userTotal = 0;

            // 이모티콘 구매 시뮬레이션
            for (int i = 0; i < m; i++) {
                if (currentDiscounts[i] >= minDiscount) {
                    userTotal += emoticons[i] * (100 - currentDiscounts[i]) / 100;
                }
            }

            // 기준 금액 초과 시 서비스 가입
            if (userTotal >= priceThreshold) {
                subscribers++;
            } else {
                totalSales += userTotal;
            }
        }

        // 결과 업데이트
        if (subscribers > maxSubscribers || (subscribers == maxSubscribers && totalSales > maxSales)) {
            maxSubscribers = subscribers;
            maxSales = totalSales;
        }
    }
}
