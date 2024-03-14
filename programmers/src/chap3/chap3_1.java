package chap3;

import java.util.*;

// 교점에 점 만들기
public class chap3_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("2차원 배열의 행 수를 입력하세요 : ");
        int line = sc.nextInt();
        int[][] arr = new int[line][3];
        System.out.println("배열을 입력해주세요");
        for (int i = 0; i < line; i++) {
            System.out.print( i + "번째 행 입력 : ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(sc.next());
            }
        }

        chap3_1 c3_1 = new chap3_1();

        System.out.println(Arrays.toString(c3_1.solution(arr)));
    }

    // 좌표 클래스
    private static class Point {
        public final long x,y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 교점 구하기
    // a1x + b1y + c1 = 0
    // a2x + b2y + c2 = 0 일 때 교점은
    // x = (b1c2 - b2c1) / (a1b2 - a2b1)
    // y = (a2c1 - a1c2) / (a1b2 - a2b1)
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if(x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long) x, (long) y);
    }

    // 최소 좌표 구하기
    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x,y);
    }

    // 최대 좌표 구하기
    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        return new Point(x,y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point interSection = intersection(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);
                if (interSection != null) {
                    points.add(interSection);
                }
            }
        }

        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, ',');
        }

        for (Point p : points) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (p.y - minPoint.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
