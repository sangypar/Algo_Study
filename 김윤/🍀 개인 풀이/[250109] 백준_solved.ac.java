package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110_solveac {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] opinion = new int[N];
		int hard = 0;
		
		for (int i = 0; i < N; i++) {
			opinion[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(opinion);
		
		if (N != 0) {
			double sum = 0;
			int exception = (int) Math.round(N * 0.15);
			
			for (int i = exception; i < N - exception; i++) {
				sum += opinion[i];
			}
			
			hard = (int) Math.round(sum / (N - exception * 2));
		}
		
		System.out.println(hard);
	}
	
}
