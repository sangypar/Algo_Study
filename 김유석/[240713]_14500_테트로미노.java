import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_16_14500_테트로미노2 {
	/*
	 * -- * 2
	 * ㅁ *1
	 * ㄱ *4 *2좌우 대칭
	 * ㄹ *4
	 * ㅗ *4
	 */
	static int[][] dr = {{0,0,0,0},{0,0,1,1},{0,1,2,2},{0,1,1,2},{0,0,0,1},
			{0,1,2,3},{0,1,2,2},{0,0,1,2},{0,0,1,2},{0,1,1,2},
			{0,0,1,1},{0,0,1,1},{0,1,1,2},{0,1,1,1},{0,1,1,2},
			{0,0,0,1},{0,1,1,1},{0,0,0,1},{0,1,1,1}};
	static int[][] dc = {{0,1,2,3},{0,1,0,1},{0,0,0,1},{0,0,1,1},{0,1,2,1},
			{0,0,0,0},{1,1,0,1},{0,1,0,0},{0,1,1,1},{1,0,1,0},
			{1,2,0,1},{0,1,1,2},{1,0,1,1},{1,0,1,2},{0,0,1,0},
			{0,1,2,0},{0,0,1,2},{0,1,2,2},{2,0,1,2}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0 ;i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxSum = -1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				outer : for(int tetNum = 0; tetNum<dr.length; tetNum++) { //도형갯수만큼
					int[] nowXs = dr[tetNum]; //도형 4방향 좌표넣기
					int[] nowYs = dc[tetNum];//도형 4방향 좌표넣기
					int sum = 0;
					for(int k = 0; k<4; k++) {
						int curX = i+nowXs[k];
						int curY = j+nowYs[k];
						if(curX < 0 || curY <0 || curX >= n || curY >=m) {
							
							continue outer;
						}
						
						sum+= map[curX][curY];
					}
					maxSum = Math.max(maxSum, sum);
				}	
			}
		}
		System.out.println(maxSum);
	}
}