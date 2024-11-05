package day_1031;
import java.util.*;
import java.io.*;

public class boj_1865_G3 {
    static ArrayList<Pair> pairs;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 지점 수
            int m = Integer.parseInt(st.nextToken()); // 도로 수
            int w = Integer.parseInt(st.nextToken()); // 웜홀 수

            pairs = new ArrayList<>();

            // 도로 입력 (양방향)
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1; // 인덱스 조정
                int e = Integer.parseInt(st.nextToken()) - 1; // 인덱스 조정
                int t = Integer.parseInt(st.nextToken());

                pairs.add(new Pair(s, e, t));
                pairs.add(new Pair(e, s, t)); // 양방향
            }

            // 웜홀 입력 (단방향)
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1; // 인덱스 조정
                int e = Integer.parseInt(st.nextToken()) - 1; // 인덱스 조정
                int t = Integer.parseInt(st.nextToken());

                pairs.add(new Pair(s, e, -t)); // 단방향, 시간은 음수
            }

            if (hasNegativeCycle(n)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }

    static boolean hasNegativeCycle(int n) {
        dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0; // 임의의 한 노드(0번 노드)를 출발점으로 설정

        // 벨만-포드 알고리즘 수행
        for (int i = 0; i < n - 1; i++) {
            for (Pair pair : pairs) {
                if (dist[pair.start] != INF &&
                        dist[pair.end] > dist[pair.start] + pair.time) {
                    dist[pair.end] = dist[pair.start] + pair.time;
                }
            }
        }

        // 음수 사이클 체크
        for (Pair pair : pairs) {
            if (dist[pair.start] != INF &&
                    dist[pair.end] > dist[pair.start] + pair.time) {
                return true; // 음수 사이클 존재
            }
        }

        return false;
    }

    static class Pair {
        int start;
        int end;
        int time;

        Pair(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}