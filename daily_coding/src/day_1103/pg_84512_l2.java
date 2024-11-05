package day_1103;

import java.util.*;

// 프로그래머스 - 완전탐색 - 모음사전(LV 2)
public class pg_84512_l2 {
    static List<String> words = new ArrayList<>();
    char[] alphabets = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        // 모든 단어 생성
        generateWords("");

        // 단어 위치 찾기
        return words.indexOf(word);
    }

    // 모든 가능한 단어를 생성하는 재귀 함수
    private void generateWords(String currentWord) {
        // 단어 길이가 5를 넘으면 중단
        if (currentWord.length() > 5) {
            return;
        }

        // 현재 단어를 리스트에 추가
        words.add(currentWord);

        // 각 모음을 붙여 새로운 단어 생성
        for (char vowel : alphabets) {
            generateWords(currentWord + vowel);
        }
    }
}
