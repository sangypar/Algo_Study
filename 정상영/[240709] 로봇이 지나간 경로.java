import java.io.*;
import java.util.*;

public class Main {

    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        h = sc.nextInt();
        w = sc.nextInt();
        sc.nextLine();

        map = new char[h][w];
        visited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int startR = -1;
        int startC = -1;

        outer: for(int r = 0; r < h; r++) {
            for(int c = 0; c < w; c++) {
                // 시작점을 찾지 못했고, 4면 중 한 면만 #일때 시작할 수 있음
                if(startR == -1 && startC == -1 && map[r][c] == '#' && checkStart(r, c)) {
                    startR = r;
                    startC = c;
                    break outer;
                }
            }
        }

        sb.append(startR + 1).append(" ").append(startC + 1).append("\n");

        operation(startR, startC);
        
        System.out.println(sb);
    }

    static boolean checkStart(int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int cnt = 0;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == '#') {
                cnt++;
            }
        }

        if(cnt == 1) return true;

        return false;
    }
    
    static void operation(int r, int c) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r, c});
        visited[r][c] = true;
        boolean isFirst = true;
        char dir = 'X';

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                int nr2 = currR + dr[d] * 2;
                int nc2 = currC + dc[d] * 2;

                // 경계 안이면서 방문한 적 없고, 앞으로 두칸까지가 #이면
                if(nr2 >= 0 && nr2 < h && nc2 >= 0 && nc2 < w && !visited[nr][nc] && !visited[nr2][nc2] && map[nr][nc] == '#' && map[nr2][nc2] == '#') {
                    // 첫 방향 찾기
                    if(isFirst) {
                        switch(d) {
                                case 0:
                                sb.append(">").append("\n");
                                dir = 'R';
                                break;
                                case 1:
                                sb.append("v").append("\n");
                                dir = 'D';
                                break;
                                case 2:
                                sb.append("<").append("\n");
                                dir = 'L';
                                break;
                                case 3:
                                sb.append("^").append("\n");
                                dir = 'U';
                                break;
                        }
                        // 이제 처음 아님
                        isFirst = false;
                        
                    // 회전할 방향 찾아야 함
                    } else {
                        switch(d) {
                                case 0: // 오른쪽으로 가야함
                                    switch(dir) { // 기존 방향이
                                            case 'R':
                                            break;
                                            case 'D':
                                            sb.append("L");
                                            break;
                                            case 'L':
                                            sb.append("R").append("R");
                                            break;
                                            case 'U':
                                            sb.append("R");
                                            break;
                                    }
                                dir = 'R';
                                break;
                                case 1: // 아래쪽
                                    switch(dir) {
                                            case 'R':
                                            sb.append("R");
                                            break;
                                            case 'D':
                                            break;
                                            case 'L':
                                            sb.append("L");
                                            break;
                                            case 'U':
                                            sb.append("L").append("L");
                                            break;
                                    }
                                dir = 'D';
                                break;
                                case 2: // 왼쪽
                                    switch(dir) {
                                            case 'R':
                                            sb.append("L").append("L");
                                            break;
                                            case 'D':
                                            sb.append("R");
                                            break;
                                            case 'L':
                                            break;
                                            case 'U':
                                            sb.append("L");
                                            break;
                                    }
                                dir = 'L';
                                break;
                                case 3: // 위쪽
                                    switch(dir) {
                                            case 'R':
                                            sb.append("L");
                                            break;
                                            case 'D':
                                            sb.append("R").append("R");
                                            break;
                                            case 'L':
                                            sb.append("R");
                                            break;
                                            case 'U':
                                            break;
                                    }
                                dir = 'U';
                                break;
                        }
                    }

                    queue.add(new int[]{nr2, nc2});
                    visited[nr][nc] = true;
                    visited[nr2][nc2] = true;
                    sb.append('A');
                }
            }
            
        }
    }
}
