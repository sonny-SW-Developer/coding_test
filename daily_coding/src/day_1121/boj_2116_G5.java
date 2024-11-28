package day_1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2116_G5 {
    static int[][] arr;
    // 각 면마다 반대편에 해당하는 값을 저장
    static int[] dices = new int[]{5,3,4,1,2,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num][6];
        int answer = 0;

        // 정보 저장
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 주사위의 윗면을 모두 탐색
        for(int i=0; i<6; i++) {
            int[][] temp = new int[num][2];
            // 윗면 정보 저장
            temp[0][1] = arr[0][i];
            // 아랫면 정보 저장
            temp[0][0] = arr[0][dices[i]];

            for(int j=1; j<num; j++) {
                // 밑면 정보 저장
                temp[j][0] = temp[j-1][1];
                // 윗면 인덱스 정보 가져오기
                int idx = getIndex(temp[j][0], j);
                // 윗면 정보 저장
                temp[j][1] = arr[j][idx];
            }

            int sum = 0;
            // temp의 위, 아래에 포함되지 않는 값의 최대값을 구한다.
            for(int j=0; j< temp.length; j++) {
                // 최대 주사위의 값
                int max = Integer.MIN_VALUE;
                for(int k : arr[j]) {
                    if(k == temp[j][0] || k == temp[j][1]) continue;
                    max = Math.max(max, k);
                }
                sum += max;
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    static int getIndex(int val, int j) {
        int index = -1;
        for(int i=0; i<6; i++) {
            if(val == arr[j][i]) {
                index = i;
                break;
            }
        }

        for(int num : dices) {
            if(num == index) return num;
        }
        return index;
    }
}
