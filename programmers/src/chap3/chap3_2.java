package chap3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class chap3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(Arrays.toString(solution(n)));
    }

    private static int[] solution(int n) {
//    private static List<Integer> solution(int n) {
        // n=4이면, arr은 0~3까지 4개가 생성.
        int[][] arr = new int[n + 1][];

        int totalLength = 0;
        // 1~4까지 돌림
        for (int i = 1; i <= n; i++) {
            // arr[1] = new int[2];
            // arr[2] = new int[3];
            arr[i] = new int[i + 1];
            totalLength += arr[i].length-1;
        }
        int num = 1;
        for (int i = 1; i <= n; i++) {
            // i=1이면 value= 1, i=4이면 value=2, j=3부터 시작 | i=7이면 value=3, J=5부터 시작
            // i=2이면 value= 2, i=5이면 value=3, i=8이면 value=4
            int value = (i % 3) + (i / 3);

            switch (i % 3) {
                case 1:
                    // i=1이면 j=1~8까지
                    // i=4이면 j=3~7
                    // i=7이면 j=5~6
                    for (int j = i - value + 1; j <= n - value + 1; j++) {
//                        System.out.println("i=" + i + "일 때, arr[" + j + "][" + value + "]" + "= " + num + "입니다.");
                        arr[j][value] = num++;
                    }
//                    System.out.println("-----");
                    break;
                case 2:
                    // i=2이면 j=2~8, value=2 -0
                    // i=5이면 j=3~6, value=3 -2
                    // i=8이면 j=4, value=4   -4
                    for (int j = value; j <= n - ((i % 3) * (i / 3)); j++) {
                        int check = n - (i / 3);
//                        System.out.println("i=" + i + "일 때, j= " + j + "arr[" + check + "][" + j + "]" + "= " + num + "입니다.");
                        arr[n - (i / 3)][j] = num++;
                    }
//                    System.out.println("-----");
                    break;
                case 0:
                    int x = n - value;
                    int y = n - (1 + (value - 1) * 2);
//                    System.out.println("x = " + x + ", y = " + y + ", value = " + value);
                    while (x >= value * 2 && y >= value + 1) {
//                        int check = n-(i/3);
//                        System.out.println("i=" + i + "일 때," + "arr[" + x + "][" + y + "]" + "= " + num + "입니다.");
                        arr[x][y] = num++;
                        x--;
                        y--;
                    }
//                    System.out.println("-----");
                    break;
            }
        }

        int[] result = new int[totalLength];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                result[index++] = arr[i][j];
            }
        }
        return result;
    }
}