package day_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686 {
    static int n,m;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) house.add(new int[]{i,j});
                else if(num == 2) chicken.add(new int[]{i,j});
            }
        }

        combination(new ArrayList<>(), 0);
        System.out.println(minDistance);
    }

    static void combination(ArrayList<int[]> selected, int start) {
        if(selected.size() == m) {
            // 선택된 치킨집에 대해 최소 거리 계산
            int totalDistance = 0;
            for(int[] h : house) {
                int minDist = Integer.MAX_VALUE;
                for(int[] c : selected) {
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }
                totalDistance += minDist;
            }
            minDistance = Math.min(minDistance, totalDistance);
            return ;
        }

        for(int i=start; i<chicken.size(); i++) {
            selected.add(chicken.get(i));
            combination(selected, i+1);
            selected.remove(selected.size()-1);
        }
    }
}
