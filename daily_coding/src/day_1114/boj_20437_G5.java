package day_1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_20437_G5 {
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            A = new ArrayList[26];
            for(int i=0; i<26; i++) {
                A[i] = new ArrayList<>();
            }

            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());

            for(int i=0; i<input.length(); i++) {
                int index = input.charAt(i) - 'a';
                A[index].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for(int i=0; i<26; i++) {
                if(A[i].size() < k) continue;

                // 슬라이딩 윈도우
                for(int j=0; j <= A[i].size() - k; j++) {
                    int len = A[i].get(j+k-1) - A[i].get(j) + 1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                // K개의 문자가 포함된 구간이 없는 경우
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
