import java.util.*;
import java.io.*;

// Test 문제 풀이 공간
public class Main {
    public static void main(String[] args) {
        ArrayList<String>[] a = new ArrayList[4];

    }
}

import java.util.*;
        import java.io.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] jisu = new int[friends.length];
        int[][] info = new int[friends.length][friends.length];
        int[] result = new int[friends.length];

        for(int i=0; i<gifts.length; i++) {
            // 주고 받은 선물 업데이트
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            int a = find(friends, name1);
            int b = find(friends, name2);
            info[a][b]++;

            // 선물 지수 업데이트
            jisu[a]++;
            jisu[b]--;
        }

        for(int i=0; i<friends.length; i++) {
            int index = find(friends, friends[i]);
            for(int j=0; j<friends.length; j++) {
                if(index == j) continue;
                // 선물 큰 경우
                if(info[index][j] > info[j][index]) {
                    result[j]++;
                } else if(info[index][j] == info[j][index]) {
                    // 주고받은 선물 개수가 같거나 기록이 하나도 없는 경우
                    if(jisu[index] > jisu[j]) result[index]++;
                }
            }
        }

        for(int i=0; i<friends.length; i++) {
            System.out.print(result[i] + " ");
        }

        int answer = 0;
        return answer;
    }

    int find(String[] friends, String name) {
        for(int i=0; i<friends.length; i++) {
            if(friends[i] == name) return i;
        }
        return 1;
    }
}