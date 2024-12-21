package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	
	static int N;
	static int[] numbers;
	static int[] operator = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		calculate(numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void calculate(int current, int index) {
		if (index == N) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				if (i == 0) calculate(current + numbers[index], index + 1);
				if (i == 1) calculate(current - numbers[index], index + 1);
				if (i == 2) calculate(current * numbers[index], index + 1);
				if (i == 3) calculate(current / numbers[index], index + 1);
				operator[i]++;
			}
		}
	}
}
