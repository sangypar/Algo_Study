import java.util.*;

class Solution {
    static char[][] classroom;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r;
        int c;
        int w;

        public Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        out: for (int t = 0; t < 5; t++) {
            classroom = new char[5][5];
            visit = new boolean[5][5];
            
            for (int r = 0; r < 5; r++) {
                String temp = places[t][r];
                
                for (int c = 0; c < 5; c++) {
                    classroom[r][c] = temp.charAt(c);
                }
            }
            
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (classroom[r][c] == 'P') {
                        if (bfs(r, c, 0) == 0) {
                            answer[t] = 0;
                            continue out;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int r, int c, int w) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        visit[r][c] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];
                
                if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    
                    if (classroom[nr][nc] == 'P') {
                        if (point.w + 1 <= 2) return 0;
                    } else if (classroom[nr][nc] == 'O') {
                        queue.offer(new Point(nr, nc, point.w + 1));
                    }
                }
            }
        }
        
        return 1;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.40ms, 80.3MB)
// 테스트 2 〉	통과 (0.57ms, 89.2MB)
// 테스트 3 〉	통과 (0.54ms, 85.8MB)
// 테스트 4 〉	통과 (0.42ms, 80.3MB)
// 테스트 5 〉	통과 (0.58ms, 99.5MB)
// 테스트 6 〉	통과 (0.40ms, 84.3MB)
// 테스트 7 〉	통과 (0.38ms, 76.3MB)
// 테스트 8 〉	통과 (0.37ms, 83.1MB)
// 테스트 9 〉	실패 (0.39ms, 88.9MB)
// 테스트 10 〉	통과 (0.45ms, 73.4MB)
// 테스트 11 〉	실패 (0.41ms, 79MB)
// 테스트 12 〉	통과 (0.42ms, 84.9MB)
// 테스트 13 〉	실패 (0.52ms, 87MB)
// 테스트 14 〉	통과 (0.38ms, 91.7MB)
// 테스트 15 〉	통과 (0.42ms, 84.2MB)
// 테스트 16 〉	통과 (0.57ms, 92.7MB)
// 테스트 17 〉	통과 (0.41ms, 73.3MB)
// 테스트 18 〉	통과 (0.35ms, 79.3MB)
// 테스트 19 〉	통과 (0.36ms, 70.2MB)
// 테스트 20 〉	통과 (0.35ms, 77.5MB)
// 테스트 21 〉	통과 (0.36ms, 82.3MB)
// 테스트 22 〉	통과 (0.35ms, 86.4MB)
// 테스트 23 〉	통과 (0.03ms, 86.8MB)
// 테스트 24 〉	통과 (0.32ms, 73.3MB)
// 테스트 25 〉	통과 (0.04ms, 76.7MB)
// 테스트 26 〉	통과 (0.03ms, 74.8MB)
// 테스트 27 〉	통과 (1.15ms, 87.8MB)
// 테스트 28 〉	통과 (0.39ms, 74.8MB)
// 테스트 29 〉	통과 (0.41ms, 82.4MB)
// 테스트 30 〉	통과 (0.38ms, 88.5MB)
// 테스트 31 〉	통과 (0.62ms, 81.8MB)
