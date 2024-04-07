package chap8;
import java.util.*;
public class chap8_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<=n; i++) {
            A.add(new ArrayList<>());
        }
        // 진입차수 배열
        int[] indegree = new int[n+1];
        for(int i=0; i<m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A.get(s).add(e);
            indegree[e]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for(int next : A.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
