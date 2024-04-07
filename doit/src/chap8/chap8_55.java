package chap8;
import java.util.*;
import java.io.*;

// 임계 경로 구하기 - 백준 1948(P)
public class chap8_55 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseA = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        int[] indegree = new int[n+1];
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            int s = int s = Integer.parseInt(br.readLine());
        }
    }
}

class Node {
    int targetNode;
    int value;
    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}
