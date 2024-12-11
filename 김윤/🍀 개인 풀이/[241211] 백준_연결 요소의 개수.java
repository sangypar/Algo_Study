package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	
	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			if (!visit[i]) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void DFS(int k) {
		visit[k] = true;
		
		for (int w : adj[k]) {
			if (!visit[w]) DFS(w);
		}
	}
	
}
