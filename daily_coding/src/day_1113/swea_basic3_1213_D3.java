package day_1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_basic3_1213_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc<=10; tc++) {
            int num = Integer.parseInt(br.readLine());
            String search = br.readLine();
            String input = br.readLine();
            int count = 0;
            for(int i=0; i<= input.length() - search.length(); i++) {
                if(input.charAt(i) != search.charAt(0)) continue;
                String temp = input.substring(i, i+search.length());
                if(temp.equals(search)) count++;
            }

            sb.append("#" + num + ": ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
