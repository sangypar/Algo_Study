import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// 백준 골드V, 치킨 배달
// 완던탐색
// 0 빈칸, 1 집, 2 치킨집
// 메모리 19,836KB, 시간 332ms
public class Main_15686 {

    static int n, m, city[][], min;
    static List<Point> house, chick;
    static boolean[] sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt(); // 치킨 집 개수
        city = new int[n][n];
        house = new ArrayList<>();
        chick = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) house.add(new Point(i, j));
                if (city[i][j] == 2) chick.add(new Point(i, j));
            }
        }
        min = Integer.MAX_VALUE;
        sel = new boolean[chick.size()];
        byeChicken(0, 0);

        System.out.println(min);
        sc.close();
    }

    public static void byeChicken(int idx, int start) {
        if (idx == m) {
            int chickDist = 0;
            for (int i = 0; i < house.size(); i++) {
                int sum = 99;
                for (int j = 0; j < chick.size(); j++) {
                    if (sel[j]) {
                        int dist = Math.abs(chick.get(j).x - house.get(i).x) + Math.abs(chick.get(j).y - house.get(i).y);
                        sum = Math.min(sum, dist);
                    }
                }
                chickDist += sum;
            }
            min = Math.min(chickDist, min);
            return;
        }
        for (int i = start; i < chick.size(); i++) {
            sel[i] = true;
            byeChicken(idx + 1, i + 1);
            sel[i] = false;
        }
    }
}
