package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inf1_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strs = input.split(" ");
        String answer = "";
        for(String str : strs) {
            if(answer.length() < str.length()) {
                answer = str;
            }
        }

        System.out.println(answer);
    }
}
