package day_1112;
import java.util.*;
import java.io.*;

public class swea_basic1_1204_D2 {
    public static void main(String[] args) throws IOException {
        // 삼성 인풋 테스트
        // System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            sb.append("#" + num + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            Score[] arr = new Score[101];
            for(int i=0; i<1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                Score temp = arr[score];
                if(temp == null) {
                    arr[score] = new Score(score, 1);
                } else {
                    arr[score] = new Score(temp.score, temp.cnt+1);
                }
            }
            Arrays.sort(arr);
            sb.append(arr[0].score + "\n");
        }
        System.out.println(sb.toString());
    }

    static class Score implements Comparable<Score> {
        int score;
        int cnt;

        Score(int score, int cnt) {
            this.score = score;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Score s) {
            if(this.cnt == s.cnt) {
                // 개수가 같다면 제일 큰 점수 순으로 정렬
                return s.score - this.score;
            }
            // 제일 많은 순으로 정렬
            return s.cnt - this.cnt;
        }
    }
}
