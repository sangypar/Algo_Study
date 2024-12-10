import java.util.*;

class Solution {
    int N, M;
    int[] oil;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public class Point {
        int r;
        int c;
        
        public Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        oil = new int[M];
        boolean[][] visit = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && visit[i][j] == false) {
                    BFS(land, visit, i, j);
                }
            }
        }
        
        int answer = 0;
        for (int value : oil) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
    
    public void BFS(int[][] land, boolean[][] visit, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));
        visit[r][c] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            set.add(point.c);
            
            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];
                
                if (nr >= 0 && nc >= 0 && nr < land.length && nc < land[0].length && land[nr][nc] == 1 && !visit[nr][nc]) {
                    queue.offer(new Point(nr, nc));
                    visit[nr][nc] = true;
                    count += 1;
                }
            }
        }
        
        for (int index : set) {
            oil[index] += count;
        }
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.62ms, 79.9MB)
// 테스트 2 〉	통과 (0.95ms, 90.8MB)
// 테스트 3 〉	통과 (0.37ms, 76MB)
// 테스트 4 〉	통과 (0.43ms, 72.7MB)
// 테스트 5 〉	통과 (0.54ms, 94.3MB)
// 테스트 6 〉	통과 (1.36ms, 79.9MB)
// 테스트 7 〉	통과 (1.44ms, 90.3MB)
// 테스트 8 〉	통과 (1.25ms, 82.2MB)
// 테스트 9 〉	통과 (3.26ms, 88.6MB)
// 효율성  테스트
// 테스트 1 〉	통과 (22.36ms, 66.6MB)
// 테스트 2 〉	통과 (69.63ms, 75.9MB)
// 테스트 3 〉	통과 (58.04ms, 76.1MB)
// 테스트 4 〉	통과 (20.99ms, 65.5MB)
// 테스트 5 〉	통과 (96.61ms, 73.5MB)
// 테스트 6 〉	통과 (22.60ms, 66.6MB)
