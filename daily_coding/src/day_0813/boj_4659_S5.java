package day_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4659_S5 {
    static char[] moeum = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.equals("end")) {
                break;
            } else {
                solution(input);
            }
        }
        System.out.println(sb.toString());
    }

    static void solution(String input) {
        boolean isContainMoeum = false;
        boolean isContinue = false;
        int moeumCount = 0;
        int jaeumCount = 0;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            boolean isMoeum = false;
            for(char m : moeum) {
                if(c == m) {
                    isMoeum = true;
                    isContainMoeum = true;
                    moeumCount++;
                    jaeumCount = 0;
                    break;
                }
            }

            // 자음이라면
            if(!isMoeum) {
                moeumCount = 0;
                jaeumCount++;
            }

            if(moeumCount >= 3 || jaeumCount >= 3) {
                isContinue = true;
                break;
            }

            if(i > 0) {
                char tmp = input.charAt(i-1);
                if(tmp == c && !(c == 'e' || c == 'o')) {
                    isContinue = true;
                    break;
                }
            }
        }

        if(isContinue || !isContainMoeum) {
            sb.append("<").append(input).append("> is not acceptable.\n");
        } else {
            sb.append("<").append(input).append("> is acceptable.\n");
        }
    }
}
