package day_1107;
import java.util.*;
import java.io.*;
public class boj_1461_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > 0) {
                plusList.add(num);
            } else {
                minusList.add(-num);
            }
        }

        // 절댓값 기준 내림차순 정렬
        Collections.sort(plusList, Collections.reverseOrder()); // 11 2
        Collections.sort(minusList, Collections.reverseOrder()); // 39 37 29 28 6

        int totalDistance = 0;

        // 가장 먼 거리를 한 번만 왕복 처리
        if (!plusList.isEmpty() && (minusList.isEmpty() || plusList.get(0) >= minusList.get(0))) {
            // 양수 리스트가 비어있지 않고, (음수 리스트가 비어있거나 양수 리스트 값이 더 클 때)
            totalDistance += plusList.get(0);
            for (int i = 0; i < m && !plusList.isEmpty(); i++) {
                plusList.remove(0);
            }
        } else if (!minusList.isEmpty() ) {
            // 음수 리스트가 비어있지 않고, 음수 리스트 값이 더 클 때
            totalDistance += minusList.get(0);
            for (int i = 0; i < m && !minusList.isEmpty(); i++) {
                minusList.remove(0);
            }
        }

        System.out.println("total: " + totalDistance + ", plustList Size: " + plusList.size() + ", minusList Size: " + minusList.size());

        // 나머지 양수 그룹 처리
        for (int i = 0; i < plusList.size(); i += m) {
            System.out.println("plusList에서 더해지는 값: " + plusList.get(i) * 2);
            totalDistance += plusList.get(i) * 2; // 왕복 거리
        }

        // 나머지 음수 그룹 처리
        for (int i = 0; i < minusList.size(); i += m) {
            System.out.println("minusList에서 더해지는 값: " + minusList.get(i) * 2);
            totalDistance += minusList.get(i) * 2; // 왕복 거리
        }

        System.out.println(totalDistance);
    }
}
