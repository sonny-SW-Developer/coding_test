package day_1128;
import java.util.*;
public class pg_150367_Lv3 {
    // 2023 카카오 기출문제 : 표현 가능한 이진트리
    // https://school.programmers.co.kr/learn/courses/30/lessons/150367
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 숫자를 이진수로 변환
            String binary = Long.toBinaryString(numbers[i]);
            int treeSize = getFullBinaryTreeSize(binary.length()); // 포화 이진트리 크기 계산
            String paddedBinary = padBinary(binary, treeSize); // 이진수를 포화 이진트리 길이로 패딩

            if (isValidTree(paddedBinary)) {
                result[i] = 1; // 유효한 이진트리로 표현 가능
            } else {
                result[i] = 0; // 표현 불가능
            }
        }

        return result;
    }

    // 포화 이진트리의 노드 개수 계산
    private int getFullBinaryTreeSize(int length) {
        int size = 1;
        while (size < length) {
            // 2^h - 1 형태
            size = size * 2 + 1;
        }
        return size;
    }

    // 이진수를 포화 이진트리 크기로 패딩
    private String padBinary(String binary, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - binary.length(); i++) {
            sb.append("0"); // 앞에 0을 추가
        }
        sb.append(binary);
        return sb.toString();
    }

    // 이진트리가 유효한지 확인
    private boolean isValidTree(String binary) {
        return checkTree(binary, 0, binary.length() - 1);
    }

    // 트리의 유효성을 재귀적으로 검사
    private boolean checkTree(String binary, int start, int end) {
        if (start > end) return true; // 리프 노드까지 확인 완료

        int mid = (start + end) / 2; // 루트 노드
        char root = binary.charAt(mid);

        // 루트가 0인데 서브트리에 1이 존재하면 유효하지 않음
        if (root == '0') {
            for (int i = start; i <= end; i++) {
                if (binary.charAt(i) == '1') return false;
            }
        }

        // 왼쪽과 오른쪽 서브트리도 검사
        return checkTree(binary, start, mid - 1) && checkTree(binary, mid + 1, end);
    }
}
