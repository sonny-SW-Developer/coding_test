package chap4;
import java.util.*;
import java.io.*;
public class ex4_4 {
    // 방문 여부
    static boolean[][] visited;
    // 육지, 바다
    static int[][] A;
    static int n,m, point;
    static Pair person;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken());
        person = new Pair(x, y);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs());
    }

    static void turn() {
        point -= 1;
        if(point == -1) point = 3;
    }

    static int dfs() {
        int cnt = 0;
        int turn_time = 0;
        while(true) {
            turn();
            int nx = person.x + dx[point];
            int ny = person.y + dy[point];
            // 회전 이후 정면에 가보지 않은 칸이 존재하는 경우
            if(!visited[nx][ny] && A[nx][ny] == 0) {
                visited[nx][ny] = true;
                person.x = nx;
                person.y = ny;
                cnt++;
                turn_time = 0;
                continue;
            }
            // 회전 이후 정면에 가보지 않은 칸이 없거나, 바다인 경우
            else turn_time ++;
            // 네 방향 모두 갈 수 없는 경우
            if(turn_time == 4) {
                nx = person.x - dx[point];
                ny = person.y - dy[point];
                // 뒤로 갈 수 있다면 이동
                if(A[nx][ny] == 0) {
                    person.x = nx;
                    person.y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time = 0;
            }

        }
        return cnt;
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
