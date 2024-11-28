package day_1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1374_G5 {
    // 강의실 (G5)
    // https://www.acmicpc.net/problem/1374
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lecture = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[i][0] = start;
            map[i][1] = end;
        }

        // 시작 시간이 제일 빠른 순으로 정렬
        Arrays.sort(map, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]); // 종료 시간 기준 정렬
            return Integer.compare(o1[0], o2[0]); // 시작 시간 기준 정렬
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int [] lecture : map) {
            int start = lecture[0];
            int end = lecture[1];

            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}
