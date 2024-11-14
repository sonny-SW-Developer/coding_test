package day_1112;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2179_G4 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] words = new String[num];

        for(int i=0; i<num; i++) {
            words[i] = br.readLine();
        }

        int maxLen = 0;
        int s = -1;
        int e = -1;

        // 모든 쌍을 비교하여 가장 긴 공통 접두사를 찾음
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                int curLen = getLen(words[i], words[j]);
                if (curLen > maxLen) {
                    maxLen = curLen;
                    s = i;
                    e = j;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(words[s]).append("\n").append(words[e]);
        System.out.println(sb.toString());
    }

    // 공통 접두사 길이 계산
    static int getLen(String a, String b) {
        int len = 0;
        int minLen = Math.min(a.length(), b.length());

        for(int i=0; i<minLen; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                len++;
            } else {
                break;
            }
        }

        return len;
    }
}
