import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int num = Integer.parseInt(br.readLine());


//            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}