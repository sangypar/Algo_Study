import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon1_18_15686_치킨배달 {
    private static int willClose;
    private static int minDistance = Integer.MAX_VALUE;
    private static List<int[]> chickenList = new ArrayList<>();
    private static List<int[]> houseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        int nowCnt = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                    nowCnt++;
                } else if (map[i][j] == 1) {
                    houseList.add(new int[]{i, j});
                }
            }
        }
        willClose = nowCnt - m;
        dfs(map, n, 0);
        System.out.println(minDistance);
    }

    private static void dfs(int[][] map, int n, int depth) {
        if (willClose == depth) { //치킨집 다없앴어 최소값 계산해줘
            minDistance = Math.min(minDistance, calculateDistance(map, n));
            return;
        }

        for (int i = 1; i <= n; i++) {//치킨집 없앨꺼야 
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    dfs(map, n, depth + 1);
                    map[i][j] = 2;
                }
            }
        }
    }

    private static int calculateDistance(int[][] map, int n) {
        int totalDistance = 0;

        for (int[] house : houseList) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : chickenList) {
                if (map[chicken[0]][chicken[1]] == 2) { //맨하탄거리 
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    minDist = Math.min(minDist, dist);
                }
            }
            totalDistance += minDist;
        }
        return totalDistance;
    }
}
