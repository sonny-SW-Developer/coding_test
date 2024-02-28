package chap3;
import java.io.*;
import java.util.*;

// 주몽의 명령 - 백준 1253(G4)
public class chap3_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;

        for (int t=0; t<N; t++) {
            long find = arr[t];
            int i = 0;
            int j = N-1;

            // 투 포인터 알고리즘 활용
            while(i < j) {
                if(arr[i] + arr[j] == find) {
                    // 서로 다른 두수인 경우
                    if(i != t && j != t) {
                        count++;
                        break;
                    } else if (i == t) {
                        i++;
                    } else if (j == t) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
