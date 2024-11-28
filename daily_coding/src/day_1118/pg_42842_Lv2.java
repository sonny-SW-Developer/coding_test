package day_1118;

public class pg_42842_Lv2 {
    // 완전탐색 - 카펫(Lv 2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/42842
    static int[] solution(int brown, int yellow) {
        // 열 >= 행 길이
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i=2; i<=Math.sqrt(sum); i++) {
            if(sum % i == 0) {
                System.out.println("sum: " + sum +", i: " + i);
                if(check(sum, i, brown)) {
                    answer[0] = sum / i;
                    answer[1] = i;
                    break;
                }
            }
        }

        return answer;
    }

    static boolean check(int sum, int row, int brown) {
        int col = sum / row;
        int[][] arr = new int[row][col];
        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i == 0  || j == 0) count++;
                else if (i == row-1 || j == col-1) count++;
            }
        }
        System.out.println("count: " + count);
        if(count == brown) return true;
        return false;
    }
}
