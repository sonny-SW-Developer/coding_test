package day_1002;
import java.util.*;
import java.io.*;
public class boj_6603_S2 {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            int num = Integer.parseInt(st.nextToken());
            
            if(num == 0) break;

            // 배열 초기화
            arr = new int[num];
            visited = new boolean[num];
            for(int i=0; i<num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 조합 수행
            solution(0, 0);

            // 결과 출력
            System.out.println(sb.toString());
        }
    }

    static void solution(int index, int depth) {
        if(depth == 6) {
            for(int i=0; i<arr.length; i++) {
                if(visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return ;
        }

        for(int i=index; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
