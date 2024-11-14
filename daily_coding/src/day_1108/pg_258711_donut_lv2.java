package day_1108;
import java.util.*;
public class pg_258711_donut_lv2 {
    public static void main(String[] args) {
        int[][] edges = {{2,3}, {4,3}, {1,1}, {2,1}};
        int[][] edges2 = {{4,11}, {1,12}, {8,3}, {12,7}, {4,2}, {7,11}, {4,8}, {9,6}, {10,11}, {6,10}, {3,5}, {11,1}, {5,3}, {11,9}, {3,8}};

        int[] result = solution(edges);
        int[] result2 = solution(edges2);

        for(int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : result2) {
            System.out.print(num + " ");
        }
    }

    static int[] solution(int[][] edges) {
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        int[] answer = new int[4];

        // 과정 1
        for (int[] edge : edges) {
            startMap.put(edge[0], startMap.getOrDefault(edge[0], 0) + 1);
            endMap.put(edge[1], endMap.getOrDefault(edge[1], 0) + 1);
        }

        // 과정 2
        for (int node : startMap.keySet()) {
            if (startMap.get(node) > 1) {
                if (!endMap.containsKey(node)) {
                    // 생성한 정점을 의미
                    answer[0] = node;
                } else {
                    // 8자 그래프를 의미
                    answer[3] += 1;
                }
            }
        }

        for (int node : endMap.keySet()) {
            if (!startMap.containsKey(node)) {
                // 도착 정점 중, 출발 간선이 없으면 막대 그래프
                answer[2] += 1;
            }
        }

        // 도넛 그래프 개수 = 생성한 정점 out 개수 - 막대 그래프 개수 - 8자 그래프 개수
        answer[1] = startMap.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}