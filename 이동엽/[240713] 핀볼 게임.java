import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_핀볼 {

    static int n, cnt, max, map[][];
    static int starti, startj;
    static List<int[]> wormholes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            map = new int[n][n];
            wormholes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = sc.nextInt();
                    if (6 <= a && a <= 10) {
                        wormholes.add(new int[]{i, j, a});
                    }
                }
            }

            max = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    starti = i;
                    startj = j;
                    // 시작방향에서 모든 방향 go
                    for (int d = 0; d < 4; d++) {
                        if (map[i][j] == 0) {
                            cnt = 0;
                            pinBall(i, j, d);
                        }
                    }
                }
            }
            sb.append("#" + tc + " " + max + "\n");
        }
        System.out.println(sb);
        sc.close();
    }

    static void pinBall(int i, int j, int dir) {
        // 돌아오거나 블랙홀 끝
        if ((i == starti && j == startj && cnt > 0) || (map[i][j] == -1)) {
            max = Math.max(max, cnt);
            return;
        }

        // 벽
        if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
            cnt++;
            dir = (dir + 2) % 4;
        }

        if (map[i][j] == 0) { // 아무것도 x
            go(i, j, dir);
        } else if (6 <= map[i][j] && map[i][j] <= 10) { // 웜홀
            for (int[] w : wormholes) {
                if (w[2] == map[i][j] && w[0] != i && w[1] != j) { // 다른 원홀로 이동
                    int ni = w[0], nj = w[1];
                    // 다른 웜홀에서 진행
                    go(ni, nj, dir);
                    break;
                }
            }
        } else if (1 <= map[i][j] && map[i][j] == 5) { // 블록
            go(i, j, turn(map[i][j], dir));
        }
    }

    static boolean isInBound(int i, int j) {
        return 0 <= i && i < n && 0 <= j && j < n;
    }

    static void go(int i, int j, int dir) {
        if (dir == 0) { // 동
            if (isInBound(i, j + 1)) {
                pinBall(i, j + 1, dir);
            }
        } else if (dir == 1) { // 남
            if (isInBound(i + 1, j)) {
                pinBall(i + 1, j, dir);
            }
        } else if (dir == 2) { // 서
            if (isInBound(i, j - 1)) {
                pinBall(i, j - 1, dir);
            }
        } else { // 북
            if (isInBound(i - 1, j)) {
                pinBall(i - 1, j, dir);
            }
        }
    }

    static int turn(int block, int dir) {
        cnt++;
        if (block == 1) {
            if (dir == 2) return 1;
            if (dir == 3) return 0;
        }
        if (block == 2) {
            if (dir == 0) return 1;
            if (dir == 3) return 2;
        }
        if (block == 3) {
            if (dir == 1) return 2;
            if (dir == 0) return 3;
        }
        if (block == 4) {
            if (dir == 2) return 3;
            if (dir == 1) return 0;
        }
        return (dir + 2) % 4;
    }
}
