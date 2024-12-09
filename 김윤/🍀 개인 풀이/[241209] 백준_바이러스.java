package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	
	static int computer;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		computer = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[computer + 1];
		for (int i = 0; i <= computer; i++) {
			adj[i] = new ArrayList<>();
		}
		visit = new boolean[computer + 1];
		
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
		
		for (int v : adj[c]) {
			if (!visit[v]) DFS(v);
		}
	}
	
}
