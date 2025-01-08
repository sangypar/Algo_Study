package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int current = 1;
		boolean isPossible = true;
		
		for (int i = 0; i < N; i++) {
			while (current <= array[i]) {
				sb.append("+\n");
				stack.push(current++);
			}
			
			if (!stack.isEmpty() && stack.peek() == array[i]) {
				sb.append("-\n");
				stack.pop();
			} else {
				isPossible = false;
				break;
			}
		}
		
		if (isPossible) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
	
}
