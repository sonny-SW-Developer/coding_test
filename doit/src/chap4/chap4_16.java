package chap4;
import java.util.*;
import java.io.*;

// 버블 소트 프로그램1 - 백준 1377(G2)
public class chap4_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Data[] arr = new Data[n];
        for (int i=0; i<n; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);
        int max = 0;
        for (int i=0; i<n; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    private static class Data implements Comparable<Data>{
        int value;
        int index;

        Data (int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data d) {
            return this.value - d.value;
        }
    }
}
