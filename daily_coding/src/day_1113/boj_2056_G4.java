package day_1113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2056_G4 {
    static ArrayList<Integer>[] list;
    static int[] works;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        list = new ArrayList[input+1];
        works = new int[input+1];

        for(int i=1; i<=input; i++) {
            list[i] = new ArrayList<>();
        }

        // 정보 저장
        for(int i=1; i<=input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int beforeWorks = Integer.parseInt(st.nextToken());
            works[i] = time;
            for(int j=0; j<beforeWorks; j++) {
                int workNum = Integer.parseInt(st.nextToken());
                list[i].add(workNum);
            }
            Collections.sort(list[i]);
        }

        for(int i=1; i<=input; i++) {
            int maxTime = 0;
            for(int time : list[i]) {
                maxTime = Math.max(works[time], maxTime);
            }
            works[i] = maxTime + works[i];
        }

        Arrays.sort(works);
        System.out.println(works[works.length-1]);
    }
}
