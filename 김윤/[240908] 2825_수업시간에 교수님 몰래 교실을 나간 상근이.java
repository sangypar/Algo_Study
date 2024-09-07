package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] numbers = new long[N];
		long[] bitmasks = new long[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
			bitmasks[i] = bitmasking(numbers[i]);
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if ((bitmasks[i] & bitmasks[j]) != 0) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static long bitmasking(long number) {
		long bitmask = 0;
		
		while (number > 0) {
			long digit = number % 10;
			bitmask |= (1 << digit);
			number /= 10;
		}
		
		return bitmask;
	}
}
