package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	
	static int K;
	static int[] array;
	static int[] lotto = new int[6];
	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			if (str.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(str);
			K = Integer.parseInt(st.nextToken());
			array = new int[K];
			
			for (int i = 0; i < K; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void combination(int idx, int sidx) {
		if (sidx == 6) {
			for (int i = 0; i < 5; i++) {
				sb.append(lotto[i] + " ");
			}
			sb.append(lotto[5] + "\n");
			return;
		}
		
		if (idx == K) return;
		
		lotto[sidx] = array[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);
	}
	
}
