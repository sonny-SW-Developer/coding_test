package day_0812;
import java.io.*;
import java.util.*;
public class boj_13335_S1 {
    static int[] trucks;
    static int n,w,l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n : 트럭 개수
        // w : 다리 길이
        // L : 최대 하중
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        trucks = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        int curWeight = 0; // 현재 다리 위의 무게
        int time = 0;

        for(int i=1; i<=n; i++) {
            int truck = trucks[i];

            while(true) {
                // 트럭 없는 경우
                if(queue.isEmpty()) {
                    queue.add(truck);
                    curWeight += truck;
                    time++;
                    break;
                }

                // 트럭 가득 찬 경우
                else if (queue.size() == w) {
                    curWeight -= queue.poll();
                }

                // 트럭 추가할 수 있는 경우
                else {
                    if(curWeight + truck <= l) {
                        queue.add(truck);
                        curWeight += truck;
                        time++;
                        break;
                    } else {
                        // 트럭이 한 칸씩 움직임
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        time += w;
        System.out.println(time);
    }
}
