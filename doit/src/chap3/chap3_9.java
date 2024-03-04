package chap3;
import java.io.*;
import java.util.StringTokenizer;

// DNA 비밀번호 - 백준 12891(S5)
public class chap3_9 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // DNA 문자열 길이
        int S = Integer.parseInt(st.nextToken());
        // DNA 부분 문자열 길이
        int P = Integer.parseInt(st.nextToken());

        int result = 0;
        char[] A = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i]== 0) checkSecret++;
        }

        for(int i=0; i< P; i++) {
            add(A[i]);
        }

        if(checkSecret == 4) result++;

        // 슬라이딩 윈도우 처리 부분
        for (int i=P; i<S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if(checkSecret == 4)
                result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void add(char c) {
        switch(c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    private static void remove(char c) {
        switch(c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
