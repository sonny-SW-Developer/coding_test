package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inf1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'a' && c <= 'z') {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());
    }
}
