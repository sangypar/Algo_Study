package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int node;
	int count;
	
	public Node(int node, int count) {
		this.node = node;
		this.count = count;
	}
}

// 택배 배송
public class Main_5972 {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Node>> graph;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 헛간 개수
		M = Integer.parseInt(st.nextToken()); // 소들의 길 개수
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		dijkstra(0);
		System.out.println(distance[N-1]);
	}
	
	static void dijkstra(int start) {
		distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2)->o1.count - o2.count);
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if (distance[current.node] < current.count) continue;
			
			for (Node next : graph.get(current.node)) {
				if (distance[next.node] > current.count + next.count) {
					distance[next.node] = current.count + next.count;
					pq.add(new Node(next.node, distance[next.node]));
				}
			}
		}
	}
}
