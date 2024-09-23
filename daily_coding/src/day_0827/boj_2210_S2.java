package day_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2210_S2 {
    static Set<String> set = new HashSet<>();
    static int[][] map = new int[5][5];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs(i,j, String.valueOf(map[i][j]));
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int x, int y, String cur) {
        // 여섯자리를 만든 경우
        if(cur.length() == 6) {
            set.add(cur);
            return;
        }

        // 지정 좌표를 벗어난 경우
        if(x<0 || y < 0 || x >=5 || y >= 5)  return;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >= 0 && nx < 5 && ny < 5) {
                dfs(nx,ny, cur + map[nx][ny]);
            }
        }
    }
}
