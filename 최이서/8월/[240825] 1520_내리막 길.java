import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[][] map;
	static int[][] DP;
	static int ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
	   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
      
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		DP = new int[M][N];
		
		// -1로 초기화
		for (int[] arr: map) {
			Arrays.fill(DP, -1);
		}
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		DFS(0, 0);
	}

	private static void DFS(int r, int c) {
		
		if (r == M-1 && c == N-1)
		
	}

	private static boolean checkBounds(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
}