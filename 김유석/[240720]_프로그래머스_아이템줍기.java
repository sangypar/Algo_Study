import java.util.*;

/**
 * 두배로하고 
 * 도형 다 넣고
 * 내부를 다 0으로 
 * bfs 
 * 테스트 1 〉	통과 (0.21ms, 76.1MB)
테스트 2 〉	통과 (0.17ms, 74.9MB)
테스트 3 〉	통과 (0.27ms, 72.3MB)
테스트 4 〉	통과 (0.23ms, 74.3MB)
테스트 5 〉	통과 (0.18ms, 74.6MB)
테스트 6 〉	통과 (0.31ms, 76.8MB)
테스트 7 〉	통과 (0.23ms, 74.4MB)
테스트 8 〉	통과 (0.21ms, 77MB)
테스트 9 〉	통과 (0.72ms, 72.5MB)
테스트 10 〉	통과 (0.42ms, 72.9MB)
테스트 11 〉	통과 (0.58ms, 76.8MB)
테스트 12 〉	통과 (0.57ms, 79.1MB)
테스트 13 〉	통과 (0.74ms, 72.8MB)
테스트 14 〉	통과 (0.42ms, 81.1MB)
테스트 15 〉	통과 (0.21ms, 74.9MB)
테스트 16 〉	통과 (0.55ms, 74.4MB)
테스트 17 〉	통과 (0.43ms, 79.8MB)
테스트 18 〉	통과 (0.73ms, 73.9MB)
테스트 19 〉	통과 (0.68ms, 75.5MB)
테스트 20 〉	통과 (0.77ms, 75.5MB)
테스트 21 〉	통과 (0.41ms, 79.5MB)
테스트 22 〉	통과 (0.39ms, 76MB)
테스트 23 〉	통과 (0.66ms, 77.3MB)
테스트 24 〉	통과 (0.46ms, 71.2MB)
테스트 25 〉	통과 (0.40ms, 66.1MB)
테스트 26 〉	통과 (0.31ms, 77.6MB)
테스트 27 〉	통과 (0.27ms, 76.7MB)
테스트 28 〉	통과 (0.26ms, 78.6MB)
테스트 29 〉	통과 (0.41ms, 76.5MB)
테스트 30 〉	통과 (0.29ms, 77.6MB)
 */
public class Programmers_7_아이템줍기 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] rectangle = { {1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8} };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        int result = solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println(result);
    }

    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];

        // 사각형의 경계를 맵에 그리기 (2배 확대)
        for (int[] rect : rectangle) {
            int firstX = rect[0] * 2;
            int firstY = rect[1] * 2;
            int secX = rect[2] * 2;
            int secY = rect[3] * 2;
            
            /**
             * 상자 채우기 
             */
            for (int x = firstX; x <= secX; x++) {
                map[x][firstY] = 1;
                map[x][secY] = 1;
            }


            for (int y = firstY; y <= secY; y++) {
                map[firstX][y] = 1;
                map[secX][y] = 1;
            }
        }

        // 내부를 0으로 설정
        for (int[] rect : rectangle) { //1번도형, 2번도형 ....
            int firstX = rect[0] * 2; 
            int firstY = rect[1] * 2;
            int secX = rect[2] * 2;
            int secY = rect[3] * 2;
            for (int x = firstX + 1; x < secX; x++) {
                for (int y = firstY + 1; y < secY; y++) {
                    map[x][y] = 0;
                }
            }
        }

        // BFS를 사용하여 최단 경로 찾기
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private static int bfs(int startX, int startY, int goalX, int goalY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // {x, y, distance}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 목표 지점에 도달했을 때
            if (x == goalX && y == goalY) {
                return distance;
            }

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위 내에 있고 방문하지 않았으며 경계일 때
                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1; // 경로가 없는 경우
    }
}
