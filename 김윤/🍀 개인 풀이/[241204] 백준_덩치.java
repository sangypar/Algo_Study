package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][2];
		int[] ranks = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1;
			
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (array[i][0] < array[j][0] && array[i][1] < array[j][1]) {
					rank++;
				}
			}
			
			ranks[i] = rank;
		}
		
		for (int i = 0; i < N-1; i++) {
			System.out.print(ranks[i] + " ");
		}
		
		System.out.println(ranks[N-1]);
	}
	
}
