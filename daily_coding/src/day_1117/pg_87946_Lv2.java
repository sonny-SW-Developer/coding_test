package day_1117;
import java.util.*;
public class pg_87946_Lv2 {
    static int answer = 0;
    static boolean[] visited;
    static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        backTrack(dungeons, k, 0);

        return answer;
    }

    static void backTrack(int[][] dungeons, int cur, int cnt) {
        answer = Math.max(answer, cnt);

        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && cur >= dungeons[i][0]) {
                visited[i] = true;
                backTrack(dungeons, cur-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}
