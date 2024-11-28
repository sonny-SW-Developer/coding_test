package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class inf1_4 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(T-- > 0) {
            String input = br.readLine();
            solution(input);
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    // 정석 풀이
    ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    // 내 풀이
    static void solution(String input) {
        String temp = "";
        for(int i=0; i<input.length(); i++) {
            temp += input.charAt(input.length()-1-i);
        }
        sb.append(temp).append("\n");
    }
}
