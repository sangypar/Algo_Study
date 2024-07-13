import java.util.*;

public class SWEA_핀볼게임_5650 {

    static int n, startR, startC, cnt, ans;
    static int[][] map;
    static Queue<int[]> startPoints; // 출발지 목록
    static List<int[]> wormholes; // 웜홀 목록
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            map = new int[n][n];
            startPoints = new LinkedList<>();
            wormholes = new ArrayList<>();

            // 입력
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    int input = sc.nextInt();
                    map[r][c] = input;

                    // 0이면 출발지 목록에 추가
                    if(input == 0) startPoints.add(new int[]{r, c});
                        // 6에서 10사이면 웜홀 목록에 추가
                    else if(6 <= input && input <= 10) wormholes.add(new int[]{input, r, c});
                }
            }

            ans = Integer.MIN_VALUE;

            while(!startPoints.isEmpty()) {
                int[] start = startPoints.poll();
                startR = start[0];
                startC = start[1];

                for(int dir = 0; dir < 4; dir++) {
                    cnt = 0;

                    game(startR, startC, dir);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    static void game(int r, int c, int d) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        // basecase
        // 블랙홀을 만나거나, 출발지로 돌아왔다면 게임 종료
        if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
            if(map[nr][nc] == -1 || (nr == startR && nc == startC)) {
                ans = Math.max(cnt, ans);
                return;
            }
        } else {
            // 경계를 벗어난 경우 반대 방향으로 이동
            cnt++;
            game(nr, nc, (d + 2) % 4);
            return;
        }

        // recursive
        // 빈 공간이면
        if(map[nr][nc] == 0) {
            game(nr, nc, d);

            // 웜홀이라면
        } else if(6 <= map[nr][nc] && map[nr][nc] <= 10) {
            for(int[] wormhole : wormholes) {
                // 웜홀의 번호가 일치하고, 현재 위치가 아닌 곳으로
                if(map[nr][nc] == wormhole[0] && (nr != wormhole[1] || nc != wormhole[2])) {
                    game(wormhole[1], wormhole[2], d);
                    return;
                }
            }

            // 블록이라면
        } else if (1 <= map[nr][nc] && map[nr][nc] <= 5){
            cnt++;

            switch (map[nr][nc]) {
                case 1:
                    if(d == 2) game(nr, nc, 1);
                    else if(d == 3) game(nr, nc, 0);
                    else game(nr, nc, (d + 2) % 4);
                    break;
                case 2:
                    if(d == 0) game(nr, nc, 1);
                    else if(d == 3) game(nr, nc, 2);
                    else game(nr, nc, (d + 2) % 4);
                    break;
                case 3:
                    if(d == 0) game(nr, nc, 3);
                    else if(d == 1) game(nr, nc, 2);
                    else game(nr, nc, (d + 2) % 4);
                    break;
                case 4:
                    if(d == 2) game(nr, nc, 3);
                    else if(d == 1) game(nr, nc, 0);
                    else game(nr, nc, (d + 2) % 4);
                    break;
                case 5:
                    game(r, c, (d + 2) % 4);
                    break;
            }
        }
    }
}
