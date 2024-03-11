package chap3;
import java.util.*;

// 스택으로 오름차순 만들기 - 백준 1874(S3)
public class chap3_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1;
        boolean result = true;

        for(int i=0; i<A.length; i++) {
            int currentValue = A[i];
            if (currentValue >= num) {
                while (currentValue >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if(n > currentValue) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb.toString());
    }
}
