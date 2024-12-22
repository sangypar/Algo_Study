package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_5568_카드놓기 {
	
	static int N, K;
	static int[] number;
	static int[] select;
	static boolean[] visit;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		number = new int[N];
		select = new int[K];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		
		permutation(0);
		
		System.out.println(set.size());
	}
	
	static void permutation(int sidx) {
		if (sidx == K) {
			String str = "";
			
			for (int i = 0; i < K; i++) {
				str += select[i];
			}
			
			set.add(str);
			return;
		}
		
		for (int idx = 0; idx < N; idx++) {
			if (!visit[idx]) {
				visit[idx] = true;
				select[sidx] = number[idx];
				permutation(sidx + 1);
				visit[idx] = false;
			}
		}
	}
	
}
