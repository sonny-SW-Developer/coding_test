import java.util.*;
import java.io.*;

public class study {
    static int[] parent;
    public static void main(String[] args) {
        // 삼성 코테 input.txt 파일 테스트 시
//        System.setIn(new FileInputStream("C:\\Users\\fairy\\Desktop\\input.txt"));

        // 2차원 배열 정렬
        int[][] A = new int[5][2];
        Arrays.sort(A, new Comparator<int[]>() {
           @Override
           public int compare(int[] S, int[] E) {
               return S[1] - E[1];
            }
        });

        // map 개념
        HashMap<Integer, Integer> map = new HashMap<>();

        // map 삽입
        map.put(1,3);
        map.put(2,4);
        // 포함 여부 확인
        System.out.println(map.containsKey(1));
        // 키 삭제하면서 해당 value 출력
        System.out.println(map.remove(2));
        // map 반복
        for(Integer key : map.keySet()) {
            System.out.println("key: " + key);
            System.out.println("value: " + map.get(key));
        }

        // 최대공약수, 최소공배수
        int a = 7;
        int b = 5;
        System.out.println("최대공약수: " + gcd(a,b));
        System.out.println("최소공배수: " + (a * b / gcd(a,b)));

    }

    // 최대공약수, 최소공배수
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    // 유니온 파인드
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            parent[b] = a;
        }
    }
    
    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}