package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	
	static int N;
	static List<Integer>[] adj;
	static boolean[] visit;
	static StringBuilder dfs = new StringBuilder();
	static StringBuilder bfs = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
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
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		DFS(K);
		visit = new boolean[N + 1];
		BFS(K);
		
		System.out.println(dfs);
		System.out.println(bfs);
	}
	
	static void DFS(int k) {
		visit[k] = true;
		dfs.append(k).append(" ");
		
		for (int w : adj[k]) {
			if (!visit[w]) DFS(w);
		}
	}
	
	static void BFS(int k) {
		Queue<Integer> queue = new LinkedList<>();
		visit[k] = true;
		queue.add(k);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			bfs.append(current).append(" ");
			
			for (int w : adj[current]) {
				if (!visit[w]) {
					visit[w] = true;
					queue.add(w);
				}
			}
		}
	}
}
