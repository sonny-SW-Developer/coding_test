package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inf1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[26];
        for(int i=0; i<input.length(); i++) {
            arr[Character.toLowerCase(input.charAt(i)) - 'a']++;
        }

        char search = br.readLine().charAt(0);
        System.out.println(arr[Character.toLowerCase(search) - 'a']);
    }
}
