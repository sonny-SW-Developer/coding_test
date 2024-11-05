package day_1031;
import java.util.*;
import java.io.*;
public class boj_1501_G5 {
    static HashMap<String, Integer> dictionaryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사전 단어 개수
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String key = createKey(word);
            System.out.println("word: " + word + ", key: " + key);
            dictionaryMap.put(key, dictionaryMap.getOrDefault(key, 0) + 1);
        }

        // 테스트 문장 개수
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            String[] words = input.split(" ");
            int count = 1;
            for (String word : words) {
                String key = createKey(word);
                count *= dictionaryMap.getOrDefault(key, 0);
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }

    // 단어의 키를 생성하는 메소드
    static String createKey(String word) {
        if (word.length() <= 2) {
            return word; // 길이가 2 이하라면 자체가 키가 됨
        }


        char[] middle = word.substring(1, word.length() - 1).toCharArray();
        Arrays.sort(middle);
        // 첫 글자, 중간 글자 정렬, 마지막 글자
        return word.charAt(0) + new String(middle) + word.charAt(word.length() - 1);
    }
}
