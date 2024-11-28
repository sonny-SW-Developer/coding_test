package day_1123;
import java.util.*;
public class pg_258709_Lv3 {
    // 2024 카카오 - 주사위 고르기
    // https://school.programmers.co.kr/learn/courses/30/lessons/258709

    static int maxWinCount;
    static List<Integer> bestCombination;

    public int[] solution(int[][] dice) {
        int n = dice.length;
        maxWinCount = -1;
        bestCombination = new ArrayList<>();

        // A의 가능한 조합 생성
        List<List<Integer>> combinations = generateCombinations(n, n / 2);

        for (List<Integer> aCombination : combinations) {
            // A의 조합과 B의 조합 구분
            List<Integer> bCombination = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!aCombination.contains(i)) {
                    bCombination.add(i);
                }
            }

            // 각 조합에 대해 승리 횟수 계산
            int[] results = calculateResults(aCombination, bCombination, dice);

            // 승리 횟수가 최대인 경우 갱신
            if (results[0] > maxWinCount) {
                maxWinCount = results[0];
                bestCombination = new ArrayList<>(aCombination);
            }
        }

        // 결과 반환 (1-based index)
        return bestCombination.stream().map(i -> i + 1).sorted().mapToInt(i -> i).toArray();
    }

    // 조합 생성 (n개 중 r개 선택)
    private List<List<Integer>> generateCombinations(int n, int r) {
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(result, new ArrayList<>(), n, r, 0);
        return result;
    }

    private void combinationHelper(List<List<Integer>> result, List<Integer> temp, int n, int r, int start) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            temp.add(i);
            combinationHelper(result, temp, n, r, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // 승리, 무승부, 패배 횟수 계산
    private int[] calculateResults(List<Integer> aCombination, List<Integer> bCombination, int[][] dice) {
        int win = 0, draw = 0, lose = 0;

        // 모든 경우의 수 시뮬레이션
        for (int[] aRoll : generateRolls(aCombination, dice)) {
            for (int[] bRoll : generateRolls(bCombination, dice)) {
                int aSum = Arrays.stream(aRoll).sum();
                int bSum = Arrays.stream(bRoll).sum();
                if (aSum > bSum) win++;
                else if (aSum == bSum) draw++;
                else lose++;
            }
        }

        return new int[]{win, draw, lose};
    }

    // 주어진 조합에 대한 모든 주사위 굴림 경우의 수 생성
    private List<int[]> generateRolls(List<Integer> combination, int[][] dice) {
        List<int[]> result = new ArrayList<>();
        generateRollsHelper(result, new int[combination.size()], 0, combination, dice);
        return result;
    }

    private void generateRollsHelper(List<int[]> result, int[] current, int depth, List<Integer> combination, int[][] dice) {
        if (depth == combination.size()) {
            result.add(current.clone());
            return;
        }
        int diceIndex = combination.get(depth);
        for (int face : dice[diceIndex]) {
            current[depth] = face;
            generateRollsHelper(result, current, depth + 1, combination, dice);
        }
    }
}
