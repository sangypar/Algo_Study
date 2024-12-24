package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2529_부등호 {
	
	static int K;
	static String[] operator;
	static int[] select;
	static boolean[] visit = new boolean[10];
	static String max = "";
	static String min = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		operator = new String[K];
		select = new int[K+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			operator[i] = st.nextToken();
		}
		
		backtrack(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void backtrack(int index) {
		if (index == K + 1) {
			StringBuilder sb = new StringBuilder();
			
			for (int s : select) {
				sb.append(s);
			}
			
			String result = sb.toString();
			if (min.isEmpty() || result.compareTo(min) < 0) min = result;
			if (max.isEmpty() || result.compareTo(max) > 0) max = result;
			
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (!visit[i]) {
				if (index == 0 || isValid(select[index-1], i, operator[index-1])) {
					visit[i] = true;
					select[index] = i;
					backtrack(index + 1);
					visit[i] = false;
				}
			}
		}
	}
	
	static boolean isValid(int prev, int next, String op) {
		if (op.equals("<")) {
			return prev < next;
		} else {
			return prev > next;
		}
	}
	
}
