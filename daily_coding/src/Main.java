import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] files = new String[n];
        for(int i=0; i<n; i++) {
            files[i] = br.readLine();
        }

        sb = new StringBuilder();
        String before = pattern.substring(0, pattern.indexOf('*'));
        String after = pattern.substring(pattern.indexOf('*') + 1);

        for(int i=0; i<n; i++) {
            String name = files[i];
            if(name.length() >= before.length() + after.length()
            && name.startsWith(before) && name.endsWith(after)) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            if(i != n-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}