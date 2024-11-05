package day_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2457_G3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flowers.add(new Flower(start, end));
        }

        // 정렬
        Collections.sort(flowers);

        int count = 0;         // 선택한 꽃의 수
        int currentEnd = 301;  // 현재 덮고 있는 날짜의 끝
        int maxEnd = 301;      // 현재 선택할 수 있는 꽃 중 가장 긴 끝 날짜
        int idx = 0;           // 꽃 리스트의 인덱스

        while (currentEnd <= 1130) { // 목표 날짜인 11월 30일까지 덮어야 함
            boolean found = false;

            while (idx < flowers.size() && flowers.get(idx).start <= currentEnd) {
                // 현재 덮을 수 있는 구간 내에서 가장 긴 끝 날짜 찾기
                maxEnd = Math.max(maxEnd, flowers.get(idx).end);
                found = true;
                idx++;
            }

            // 덮을 수 있는 꽃이 없는 경우
            if (!found) {
                System.out.println(0);
                return;
            }

            count++;
            currentEnd = maxEnd;
//            System.out.println("currentEnd: " + currentEnd);

            // 11월 30일 이후로 덮을 수 있으면 성공
            if (currentEnd > 1130) {
                System.out.println(count);
                return;
            }
        }

        System.out.println(0);
    }

    static class Flower implements Comparable<Flower>{
        int start;
        int end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 시작 날짜가 빠른 순으로 정렬
        // 시작 날짜 같다면, 지는 날짜가 긴 순서로 정렬
        @Override
        public int compareTo(Flower f) {
            if(this.start == f.start) {
                return f.end - this.end;
            }
            return this.start - f.start;
        }
    }
}
