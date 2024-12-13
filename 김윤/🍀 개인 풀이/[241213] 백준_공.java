package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1547_공 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] ball = new int[4];
		ball[1] = 1;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int temp = ball[x];
			ball[x] = ball[y];
			ball[y] = temp;
		}
		
		int cup = 0;
		
		for (int i = 1; i < 4; i++) {
			if (ball[i] == 1) cup = i;
		}

		if (cup == 0) System.out.println(-1);
		else System.out.println(cup);
	}
	
}
