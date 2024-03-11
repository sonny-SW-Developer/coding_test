package chap3;
import java.io.*;
import java.util.*;

// 절댓값 힙 구현하기 - 백준 11286(S1)
public class chap3_14 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
           int first_abs = Math.abs(o1);
           int second_abs = Math.abs(o2);

           if (first_abs == second_abs)
               return o1 > o2 ? 1 : -1;
           else
               return first_abs - second_abs;
        });

        for (int i=0; i<n; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request != 0) {
                queue.add(request);
            } else {
                if(queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
