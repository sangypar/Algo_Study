package baekjoon_silver;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //순열 개수
		
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[N]; //나오는지 체크
		
		int start = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int n = 0; n < N; n++) {
			int now = sc.nextInt();
			
			if(start < now) {
				
				for(int i = start+1; i <= now; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				
				start = now; //다시 여기서 시작
				
			} else if(stack.peek() != now) {
				//뺄 수 없으면 같은 수열을 만들 수 없어...!
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}		
		
		System.out.println(sb);
	}
}
