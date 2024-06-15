import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7_2573_빙산 {
    private static int n;
    private static int m;
    private static int arr [][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean visited[][] ;
    private static int pieces;
    private static int year;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr =new int[n][m];

        for(int i =0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pieces = 0;
        year = 0;
        while ((pieces = countIce()) < 2) {
            if(pieces == 0 ){
                year = 0;
                break;
            }
            meltingIce();
            year++;
        }
        System.out.println(year);
    }

    private static void meltingIce() {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) { //빙하 위치 방문처리  큐 삽입
            for (int j = 0; j < m; j++) {
                if(arr[i][j]!=0){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int idx = 0;
        int idy = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int adjSea = 0;
            for (int i = 0; i < 4; i++) {
                idx = now.x + dx[i];
                idy = now.y + dy[i];

                if (0 > idx || 0 > idy || idx >= n || idy >= m) { //경계설정
                    continue;
                }
                if (!visited[idx][idy] && arr[idx][idy] == 0) { //인근 빙하 카운팅
                    adjSea++;
                }
            }	
            if (arr[now.x][now.y] - adjSea < 0) {
                arr[now.x][now.y] = 0;
            }
            else{
                arr[now.x][now.y] -= adjSea;
            }

        }
    }

    private static int countIce() {
        visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;

    }

    private static void dfs(int i, int j, boolean[][] visited) {
        visited[i][j]= true;
        for(int  k = 0 ; k < 4; k++){
            int idx = i + dx[k];
            int idy = j + dy[k];
            if (0 <= idx && idx < n && 0 <= idy && idy < m && !visited[idx][idy] && arr[idx][idy] != 0) {
                dfs(idx, idy, visited);
            }
        }
    }
}
