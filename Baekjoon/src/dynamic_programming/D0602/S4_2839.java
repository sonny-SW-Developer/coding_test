package dynamic_programming.D0602;
import java.util.*;
import java.io.*;

public class S4_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int five = n / 5 ;
        int answer = -1;
        while(five > -1) {
            int left = n - (5 * five);
            if(left % 3 == 0) {
                answer = five + (left / 3);
                break;
            } else {
                five--;
            }
        }
        System.out.println(answer);
    }
}