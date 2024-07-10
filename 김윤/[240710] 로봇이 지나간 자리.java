// 오류났어요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static char[] arrows = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];

        int x = 0;
        int y = 0;
        int index = 0;
        char arrow = ' ';

        for (int r = 0; r < H; r++) {
            String str = br.readLine();
            for (int c = 0; c < W; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        out: for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] == '#') {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '#') {
                            x = r;
                            y = c;
                            index = d;
                            arrow = arrows[d];
                            break out;
                        }
                    }
                }
            }
        }

        System.out.println((x+1) + " " + (y+1));
        System.out.println(arrow);

        StringBuilder sb = new StringBuilder();

        while (true) {
            int nr = x + 2 * dr[index];
            int nc = y + 2 * dc[index];

            if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '#') {
                sb.append("A");
                map[x + dr[index]][y + dc[index]] = '.';
                map[nr][nc] = '.';
                x = nr;
                y = nc;
            } else {
                boolean turn = false;

                for (int i = 1; i <= 3; i+=2) {
                    int nd = (index + i) % 4;
                    nr = x + dr[nd];
                    nc = y + dc[nd];

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '#') {
                        index = nd;
                        if (i == 1) sb.append("R");
                        else sb.append("L");

                        turn = true;
                        break;
                    }
                }
                if (!turn) break;
            }
        }

        System.out.println(sb.toString());
    }
}
