import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class hole {
    int x;
    int y;

    public hole(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Swea1_1_핀볼게임 {

    private static int[][] arr;
    private static int n;
    private static final int[] idx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static final int[] idy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            List<hole>[] hole = new ArrayList[11];
            for (int i = 0; i < 11; i++) {
                hole[i] = new ArrayList<>();
            }
            arr = new int[n][n];
            for (int i = 0; i < n; i++) { // 입력
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (6 <= arr[i][j] && arr[i][j] < 11) { // 웜홀 처리
                        hole[arr[i][j]].add(new hole(i, j));
                    }
                }
            }
            int maxScore = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            maxScore = Math.max(maxScore, dfs(i, j, hole, dir));
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + maxScore);
        }
    }

    private static int dfs(int startX, int startY, List<hole>[] hole, int startDir) {
        int score = 0;
        int x = startX;
        int y = startY;
        int dir = startDir;

        while (true) {
            x += idx[dir];
            y += idy[dir];

            if (x < 0 || x >= n || y < 0 || y >= n) { // 벽에 부딪히는 경우
                dir = changeDirection(dir, 5);
                score++;
                continue;
            }

            int cell = arr[x][y];

            if (cell == -1 || (x == startX && y == startY)) { // 블랙홀 또는 출발점으로 돌아온 경우
                break;
            }

            if (1 <= cell && cell <= 5) { // 블록에 따른 방향 전환
                dir = changeDirection(dir, cell);
                score++;
            }

            if (6 <= cell && cell < 11) { // 웜홀 처리
                hole newHole = findWormhole(hole[cell], x, y);
                x = newHole.x;
                y = newHole.y;
            }
        }

        return score;
    }

    private static int changeDirection(int dir, int block) {
        switch (block) {
            case 1:
                if (dir == UP) return DOWN;
                else if (dir == LEFT) return RIGHT;
                else if (dir == DOWN) return LEFT;
                else return UP;
            case 2:
                if (dir == UP) return RIGHT;
                else if (dir == LEFT) return DOWN;
                else if (dir == DOWN) return UP;
                else return LEFT;
            case 3:
                if (dir == UP) return LEFT;
                else if (dir == LEFT) return UP;
                else if (dir == DOWN) return RIGHT;
                else return DOWN;
            case 4:
                if (dir == UP) return DOWN;
                else if (dir == LEFT) return UP;
                else if (dir == DOWN) return RIGHT;
                else return LEFT;
            case 5:
                return (dir == UP) ? DOWN : (dir == DOWN) ? UP : (dir == LEFT) ? RIGHT : LEFT;
            default:
                return dir;
        }
    }

    private static hole findWormhole(List<hole> holes, int x, int y) {
        for (hole h : holes) {
            if (h.x != x || h.y != y) {
                return h;
            }
        }
        return new hole(x, y); // 오류 처리: 웜홀이 없을 경우, 원래 위치 반환
    }
}
