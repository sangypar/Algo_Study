package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	
	static int V;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		visit = new boolean[V + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		DFS(1);
		
		System.out.println(count - 1);
	}
	
	static void DFS(int c) {
		visit[c] = true;
		count++;
		
		for (int w : adj[c]) {
			if (!visit[w]) DFS(w);
		}
	}
	
}
