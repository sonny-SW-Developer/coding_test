package chap3;
import java.util.*;
import java.io.*;

// 최솟값 찾기 - 백준 11003(P5)
public class chap3_10 {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 번에 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 개수
        int N = Integer.parseInt(st.nextToken());
        // 슬라이딩 윈도우 크기
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();

        for (int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값 들어올 때 정렬 대신, 현재 수보다 큰 값을 덱에서 제거하여 시간 복잡도를 줄인다.

            // mydeque가 비어있지 않으면서 마지막 값이 현재 입력된 값보다 크면, 마지막 값 삭제
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));

            // 범위에서 벗어난 값은 덱에서 제거한다.
            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush(); // 버퍼 안에 저장되어 있던 모든 문자열을 출력한다.
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    // 시간초과
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        // 숫자 개수
//        int N = Integer.parseInt(st.nextToken());
//        // 슬라이딩 윈도우 크기
//        int L = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[N+1]; // 0 ~ 13
//        int[] D = new int[N+1]; // 0 ~ 13
//        int[] check; // 0~2
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=1; i<=N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 1 ~ 12
//        for(int i=1; i<= N; i++) {
//            check = new int[L];
//            for (int j=0; j< L; j++) {
//                int temp = i-L+ j+ 1;
//                if (temp >= 1) {
//                    check[j] = arr[temp];
//                }
//            }
//            Arrays.sort(check);
//            for (int j=0; j<L; j++) {
//                if(check[j] == 0) continue;
//                D[i] = check[j];
//                break;
//            }
//        }
//        for (int i=1; i<= N; i++) {
//            System.out.print(D[i] + " ");
//        }
//    }
}
