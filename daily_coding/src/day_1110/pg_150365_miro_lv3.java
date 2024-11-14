package day_1110;

public class pg_150365_miro_lv3 {
    int[][] array;
    String answer = null;
    StringBuilder route;
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int endRow, endCol;
    int n, m; //미로 길이
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = new StringBuilder();
        array = new int[n][m];
        endRow = r; endCol = c;
        this.n = n;
        this.m = m;
        //최단거리 계산 - 거리 k로 갈 수 있는지 여부
        int length = distance(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";
        dfs(x, y, 0, k);

        return answer == null ? "impossible" : answer;
    }

    private void dfs(int r, int c, int depth, int k){

        if(answer != null) return;
        if(depth + distance(r, c, endRow, endCol) > k) return; //현재 깊이 + 남은 거리 > k
        if(k == depth) {
            answer = route.toString();
            return;
        }
        for(int i=0; i<4; i++){

            int nextRow = r + dx[i];
            int nextCol = c + dy[i];
            if(nextRow <= n && nextCol <= m && nextRow > 0 && nextCol >0){
                route.append(dir[i]);
                dfs(nextRow, nextCol, depth+1, k);
                route.delete(depth, depth+1);
            }
        }
    }

    private int distance(int x, int y, int r, int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }
}
