package day_1031;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class hdcap {
    public static void main(String[] args) throws IOException {
        int[][] jobs1 = {{3,6,3}, {2,4,2}, {10,12,8}, {11,15,5}, {1,8,10}, {12,13,1}};
        int[][] jobs2 = {{1,2,2}, {2,3,1}, {3,4,1}, {1,4,2}};

        System.out.println("jobs1 최대 급여: " + findMaxSalary(jobs1));
        System.out.println("jobs2 최대 급여: " + findMaxSalary(jobs2));
    }

    public static int findMaxSalary(int[][] jobs) {
        // 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int n = jobs.length;
        int[] dp = new int[n];

        // 첫 번째 작업의 급여로 초기화
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            // 현재 작업을 포함하는 경우의 급여 초기화
            int includeCurrent = jobs[i][2];

            // 현재 작업과 비간섭하는 이전 작업을 찾기
            int previousJobIndex = findNonOverlappingJob(jobs, i);
            if (previousJobIndex != -1) {
                includeCurrent += dp[previousJobIndex];
            }

            // DP 테이블 업데이트 (현재 작업을 포함하지 않는 경우 vs 포함하는 경우)
            dp[i] = Math.max(dp[i - 1], includeCurrent);
        }

        return dp[n - 1];
    }

    // 이진 탐색을 통해 현재 작업과 비간섭하는 최대 인덱스를 찾는 메소드
    public static int findNonOverlappingJob(int[][] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // 현재 작업의 시작 시간보다 종료 시간이 작은 경우
            if (jobs[mid][1] <= jobs[index][0]) {
                if (jobs[mid + 1][1] <= jobs[index][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
