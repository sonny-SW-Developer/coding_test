package day_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20365_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int blueCnt = 0;
        int redCnt = 0;

        char curColor = input.charAt(0);
        if(curColor == 'B') blueCnt++;
        else redCnt++;

        for(int i=1; i<input.length(); i++) {
            if(input.charAt(i) != curColor) {
                curColor = input.charAt(i);
                if(curColor == 'B') blueCnt++;
                else redCnt++;
            }
        }
        System.out.println(Math.min(blueCnt, redCnt) + 1);
    }
}
