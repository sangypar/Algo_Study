package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송_5972 {

	static class Node_여물 implements Comparable<Node_여물> {
		int v, w;

		public Node_여물(int v, int w) {
			this.v = v; //정점번호
			this.w = w; //가중치
		}
		
		public int compareTo(Node_여물 o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int N, M; // 도착 지점과 길의 수
	static List<Node_여물>[] list;
	static int[] cost; // 비용배열
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1]; // 1번부터 N까지 도달하는 문제

		for (int n = 0; n < N + 1; n++) {
			list[n] = new ArrayList<>(); // 초기화
		}
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken()); //시작
			int e = Integer.parseInt(st.nextToken()); //끝
			int c = Integer.parseInt(st.nextToken()); //비용
			
			list[s].add(new Node_여물(e, c));
			list[e].add(new Node_여물(s, c)); //양방향
		}
		
		visit = new boolean[N+1]; //방문체크 배열
		cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE); // 최대로 가득채워
		cost[1] = 0; //1번부터 시작

		dijkstra(1);
		
//		System.out.println(Arrays.toString(cost));
		StringBuilder sb = new StringBuilder();
		sb.append(cost[N]+"\n");
		
		System.out.println(sb);

	}
	
	//다익스트라 우선순위큐써서 처리
	private static void dijkstra(int start) {
		PriorityQueue<Node_여물> pq = new PriorityQueue<>();
		pq.offer(new Node_여물(start, 0));
		
		while(!pq.isEmpty()) {
			int now = pq.poll().v;
			
			if(visit[now]) continue; //방문한적 있다면 넘어가유~
			
			//그렇지 않다면~
			visit[now] = true;
			for(Node_여물 node : list[now]) {
				//해당 노드에 연결된 노드 검색
				if(cost[node.v] > cost[now] + node.w) {
					//지금 가야할 노드 비용이 현재노드비용+다음노드비용보다 크면 갱신해야해~!
					cost[node.v] = cost[now] + node.w;
					pq.add(new Node_여물(node.v, cost[node.v])); //그거 넣어줌
				}
			}
		}
	}
	
	

	//다익스트라 우리 처음 배울때
	//이방법으로 하면 시간초과뜸!!!!
	
	
//	private static void dijkstra(int start) {
//		boolean[] visit = new boolean[N + 1]; // 방문체크해줘
//		cost[start] = 0; //시작점
//
//		for (int n = 1; n < N; n++) {
//			int min = Integer.MAX_VALUE;
//			int idx = -1; // 절대없는 숫자
//			
//			for(int m = 1; m <= N; m++) {
//				if(!visit[m] && min > cost[m]) {
//					min = cost[m];
//					idx = m;
//				}
//			}
//			
//			if(idx == -1) break;
//			
//			visit[idx] = true;
//			
//			for(Node_여물 node : list[idx]) {
//				//거기연결되어잇는 애들 다 끌구와!
//				if(!visit[node.v] && cost[node.v] > cost[idx] + node.w) {
//					cost[node.v] = cost[idx] + node.w;
//				}
//			}
//		}
//	}//메서드
}
