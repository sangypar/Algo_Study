package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		out: for (int n = 0; n < N; n++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
				
				if (stack.firstElement() == ')') {
					System.out.println("NO");
					continue out;
				}
				
				if (stack.peek() == ')') {
					stack.pop();
					stack.pop();
				}
			}
			
			if (stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
}
