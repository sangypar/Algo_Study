package baekjoon;

import java.io.*;

public class Main_9461_파도반수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] array = new long[Math.max(N+1, 6)];
			
			array[1] = 1;
			array[2] = 1;
			array[3] = 1;
			array[4] = 2;
			array[5] = 2;
			
			for (int i = 6; i <= N; i++) {
				array[i] = array[i-1] + array[i-5];
			}
			
			System.out.println(array[N]);
		}
	}
}
