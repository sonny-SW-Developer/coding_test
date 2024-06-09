package chap6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ex6_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Mate[] arr = new Mate[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            arr[i] = new Mate(name, score);
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i].getName());
        }
    }

    static class Mate implements Comparable<Mate>{
        String name;
        int score;
        Mate(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Mate mate) {
            if(this.score < mate.score) return -1;
            return 1;
        }

        String getName() {
            return this.name;
        }
    }
}
