package day_1106;
import java.util.*;
import java.io.*;
public class boj_1253_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (goodNumber(i, arr)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean goodNumber(int i, int[] arr) {
        int left = 0;
        int num = arr[i];
        int right = arr.length -1;

        while(left < right) {
            if (left == i) {
                left++;
                continue;
            }
            if (right == i) {
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];

            if(sum == num) {
                return true;
            } else if (sum < num) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
