package day_0811;
import java.util.*;
import java.io.*;

public class boj_1543_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String search = br.readLine();
        int pos;
        int answer = 0;
        while((pos = input.indexOf(search)) != -1) {
            answer++;
            input = input.substring(pos+search.length());
        }
        System.out.println(answer);
    }
}
