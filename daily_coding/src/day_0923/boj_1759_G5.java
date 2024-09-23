package day_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_G5 {
    static int l, c;
    static char[] arr;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, "");

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int index, String cur) {
        // 문자열이 구하고자 하는 길이보다 큰 경우
        if(cur.length() > l) return;

        // 문자열이 구하고자 하는 길이에 맞게 생성된 경우
        if(cur.length() == l) {
            if(isPassword(cur)) {
                list.add(cur);
            }
            return;
        }

        for (int i = index; i < c; i++) {
            // 다음 인덱스와 현재 문자열에 문자 추가
            dfs(i + 1, cur + arr[i]);
        }
    }

    static boolean isPassword(String s) {
        int mCount = 0;
        int zCount = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mCount++;
            } else {
                zCount++;
            }
        }
        boolean isMoeum = mCount > 0;
        boolean isZaeum = zCount > 1;
        return isMoeum && isZaeum;
    }
}
