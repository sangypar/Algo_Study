import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_24_15683_감시 {
    static class cam {
        int what;  // 카메라 종류
        int x;     // x 좌표
        int y;     // y 좌표
        List<Integer> dirs = new ArrayList<>();  // 감시 방향 리스트

        public cam(int what, int x, int y) {
            this.what = what;
            this.x = x;
            this.y = y;
        }

        public void addDir(int dir) {
            dirs.add(dir);
        }
    }

    private static int[][] map;  // 지도 배열
    private static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    private static int[] dy = {1, 0, -1, 0}; // 우, 하, 좌, 상
    private static List<cam> list;  // 카메라 리스트
    private static int min = Integer.MAX_VALUE;  // 최소 사각지대
    private static int area;  // 빈 공간 수
    private static int N;  // 행 수
    private static int M;  // 열 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        area = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    area++;
                }
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new cam(map[i][j], i, j));
                }
            }
        }

        dfs(0, new cam[list.size()]);
        System.out.println(min);
    }

    private static void dfs(int depth, cam[] cams) {
        if (depth == list.size()) {
            count(cams, new boolean[N][M]);
            return;
        }

        cam now = list.get(depth);
        for (int i = 0; i < 4; i++) { // 기본적으로 4방향진행 우, 하, 좌, 상
            cam c = new cam(now.what, now.x, now.y);
            switch (c.what) {
                case 1: // 기본적으로 4방향탐색
                    c.addDir(i);
                    cams[depth] = c;
                    dfs(depth + 1, cams);
                    break;
                case 2:
                    if (i >= 2) return; // 기본적으로 2방향 진행
                    c.addDir(i); // 0
                    c.addDir(i + 2); // 2
                    cams[depth] = c;
                    dfs(depth + 1, cams);
                    break;
                case 3:
                    c.addDir(i);
                    c.addDir((i + 1) % 4);
                    cams[depth] = c;
                    dfs(depth + 1, cams);
                    break;
                case 4:
                    c.addDir(i);
                    c.addDir((i + 1) % 4);
                    c.addDir((i + 2) % 4);
                    cams[depth] = c;
                    dfs(depth + 1, cams);
                    break;
                case 5:
                    if (i > 0) return;
                    c.addDir(i);
                    c.addDir((i + 1) % 4);
                    c.addDir((i + 2) % 4);
                    c.addDir((i + 3) % 4);
                    cams[depth] = c;
                    dfs(depth + 1, cams);
                    break;
            }
        }
    }

    private static void count(cam[] cams, boolean[][] visited) {
        int cnt = 0;
        for (int i = 0; i < cams.length; i++) {
            cam c = cams[i];
            for (int j = 0; j < c.dirs.size(); j++) {
                int dir = c.dirs.get(j);
                int idx = c.x + dx[dir];
                int idy = c.y + dy[dir];
                while (0 <= idx && idx < N && 0 <= idy && idy < M) {
                    if (map[idx][idy] == 0) { // 빈곳이면서
                        if (!visited[idx][idy]) { // 방문안했으면
                            cnt++;
                            visited[idx][idy] = true;
                        }
                    } else if (map[idx][idy] == 6) break;
                    idx += dx[dir];
                    idy += dy[dir];
                }
            }
        }
        min = Math.min(min, area - cnt);
    }
}
