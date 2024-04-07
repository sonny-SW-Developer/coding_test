package chap8;
import java.io.*;
import java.util.*;

// 거짓말쟁이가 되긴 싫어 - 백준 1043(G4)
public class chap8_52 {
    static int[] parent;
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        result = 0;
        trueP = new int[t];
        for(int i=0; i<t; i++) {
            trueP[i] = sc.nextInt();
        }
        party = new ArrayList[m];
        for(int i=0; i<m; i++) {
            party[i] = new ArrayList<Integer>();
            int size = sc.nextInt();
            for(int j=0; j<size; j++) {
                party[i].add(sc.nextInt());
            }
        }
        parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;
        // 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for(int i=0; i<m; i++) {
            int first = party[i].get(0);
            for(int j=1; j<party[i].size(); j++) union(first, party[i].get(j));
        }

        // 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같으면 과장할 수 없음.
        for(int i=0; i<m; i++) {
            boolean possible = true;
            int cur = party[i].get(0);
            for(int j=0; j<trueP.length; j++) {
                if(find(cur) == find(trueP[j])) {
                    possible = false;
                    break;
                }
            }
            if(possible) result++;
        }
        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return true;
        else return false;
    }
}
