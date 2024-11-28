package day_1120;
import java.util.*;
public class pg_42839_Lv2 {
    public int solution(String numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[numbers.length()];

        getNumber(numbers, "", visited, list);
        return list.size();
    }

    // 모든 경우의 수 생성
    static void getNumber(String numbers, String cur,
                          boolean[] visited, ArrayList<Integer> list) {

        if(!cur.isEmpty()) {
            int num = Integer.parseInt(cur);
            if((list.indexOf(num) == -1) && isPrime(num)) {
                list.add(num);
            }
        }

        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                getNumber(numbers, cur + numbers.charAt(i), visited, list);
                visited[i] = false;
            }
        }
    }

    // 소수 여부 판별
    static boolean isPrime(int num) {
        if (num < 2) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
