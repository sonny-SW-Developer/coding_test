package day_1113;

import java.io.*;

public class boj_31926_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        int daldidalgo = 8;
        int daldidan = 2;
        int count = 0;
        while(n>1){
            n/=2;
            count++;
        }
        System.out.println(daldidalgo + count + daldidan);
    }
}
