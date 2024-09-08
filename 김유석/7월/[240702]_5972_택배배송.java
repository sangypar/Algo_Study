import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BaekJoon1_19_5972_택배배송 {
	static class Node implements Comparable<Node>{
		int to;
		int w;
		public Node(int to, int w) {

			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}
	private static boolean[] visited;
	private static int[] min;
	private static List<Node>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		min = new int[n+1];
		
		
		for(int i = 0 ; i <= n ; i++) {
			adjList[i]= new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
		
			adjList[from].add(new Node(to, w));
			adjList[to].add(new Node(from,w));
			//양방향
		}
		
		Arrays.fill(min, Integer.MAX_VALUE);
		dij();
		System.out.println(min[n]);
		
	}
	private static void dij() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min[1] = 0; //0생략 1번 노드 부터 시작
		pq.offer(new Node(1,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.to]) {
				visited[now.to]=true; //방문처리;
			}else {
				continue;
			}
			for(int i = 0 ; i< adjList[now.to].size() ; i++	) { //인접한 곳 방문
				Node next = adjList[now.to].get(i);
				if(min[next.to]> min[now.to]+ next.w) {
					min[next.to ] = min[now.to] + next.w;
					pq.offer(new Node(next.to, min[next.to]));
				}
			}
		}
		
	}
}
