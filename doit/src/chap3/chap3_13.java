package chap3;
import java.io.*;
import java.util.*;

// 카드 게임 - 백준 2164(S4)
public class chap3_13 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
