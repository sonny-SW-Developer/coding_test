package chap3;
import java.io.*;
import java.util.*;

// 오큰수 구하기 - 백준 17298(G4)
public class chap3_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N]; // 수열 배열
        int[] answer = new int[N]; // 정답 배열

        String[] str = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<N; i++) {
            // 스택이 비어있지 않고, 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
