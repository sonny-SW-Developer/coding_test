package day_1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_basic4_1218_D4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : arr) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    stack.push(c);
                } else {
                    // 닫는 괄호인 경우
                    if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']') || stack.peek() == '<' && c == '>') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            boolean isClear = stack.isEmpty();

            sb.append("#").append(tc).append(" ").append(isClear ? "1" : "0").append("\n");
        }
        System.out.print(sb.toString());
    }
}
