package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] set = new boolean[21];
		int M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("add")) {
				int value = Integer.parseInt(st.nextToken());
				
				if (!set[value]) {
					set[value] = true;
				}
			} else if (command.equals("remove")) {
				int value = Integer.parseInt(st.nextToken());
				
				if (set[value]) {
					set[value] = false;
				}
			} else if (command.equals("check")) {
				int value = Integer.parseInt(st.nextToken());
				
				if (set[value]) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (command.equals("toggle")) {
				int value = Integer.parseInt(st.nextToken());
				
				if (set[value]) {
					set[value] = false;
				} else {
					set[value] = true;
				}
			} else if (command.equals("all")) {
				for (int i = 1; i < 21; i++) {
					set[i] = true;
				}
			} else if (command.equals("empty")) {
				for (int i = 1; i < 21; i++) {
					set[i] = false;
				}
			}
		}
		
		System.out.print(sb.toString());
	}
	
}
