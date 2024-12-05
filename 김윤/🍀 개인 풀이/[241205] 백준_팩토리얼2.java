package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_27433_팩토리얼2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(recursion(N));
	}
	
	static long recursion(int number) {
		if (number == 0 || number == 1) return 1;
		return number * recursion(number - 1);
	}
	
}
