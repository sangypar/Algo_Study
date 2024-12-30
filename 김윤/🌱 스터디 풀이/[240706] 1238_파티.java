package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
	
	static int N; // 학생 수
	static int M; // 도로 수
	static int X; // 파티 열린 곳
	static ArrayList<ArrayList<Node>> adj, reverse_adj; // 그래프, 역방향 그래프
	static int[] distance, reverse_distance; // 배열, 역방향 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		distance = new int[N+1];
		reverse_distance = new int[N+1];
		adj = new ArrayList<>();
		reverse_adj = new ArrayList<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(reverse_distance, Integer.MAX_VALUE);
		
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
			reverse_adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Node(b, t));
			reverse_adj.get(b).add(new Node(a, t));
		}
		
		dijkstra(adj, distance, X);
		dijkstra(reverse_adj, reverse_distance, X);
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, distance[i] + reverse_distance[i]);
		}
		
		System.out.println(max);
	}
	
	static void dijkstra(ArrayList<ArrayList<Node>> list, int[] array, int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
		array[start] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			for (Node next : list.get(current.node)) {
				if (array[next.node] > array[current.node] + next.time) {
					array[next.node] = array[current.node] + next.time;
					queue.add(new Node(next.node, distance[next.node]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int node;
		int time;
		
		public Node(int node, int time) {
			this.node = node;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}
