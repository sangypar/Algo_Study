package baekjoon_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {

	static class NodeTown implements Comparable<NodeTown> {
		int num, time; // 마을번호, 소요시간

		public NodeTown(int num, int time) {
			this.num = num; // 정점번호
			this.time = time; // 가중치
		}

		public int compareTo(NodeTown o) {
			return Integer.compare(this.time, o.time);
		}
	}

	static int N, M, X;
	static List<NodeTown>[] list;
	static int[] timeToGO; // 시간배열
	static int[] timeToBack; // 시간배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생수
		M = Integer.parseInt(st.nextToken()); // 도로수
		X = Integer.parseInt(st.nextToken()); // 모이는 마을번호

		list = new ArrayList[N + 1]; // 1번부터 N까지 도달하는 문제

		for (int n = 0; n < N + 1; n++) {
			list[n] = new ArrayList<>(); // 초기화
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()); // 시작
			int e = Integer.parseInt(st.nextToken()); // 끝
			int t = Integer.parseInt(st.nextToken()); // 시간

			list[s].add(new NodeTown(e, t)); // 단방향
		} // 입력완

		timeToGO = new int[N + 1]; // X로 가는 배열
		timeToBack = new int[N + 1]; // X에서 오는 배열
		Arrays.fill(timeToBack, Integer.MAX_VALUE); // 최대로 가득채워
		
		for (int i = 1; i <= N; i++) {
			// 마을 1번부터 돕니다
			dijkstra(i);
		}

		timeToBack[X] = 0; // X에서 X로 가는 시간은 0이다.
		dijkstraBack(X); // X에섯 시작하는 모든 수

		int max = 0; // 최대시간

		for (int n = 1; n <= N; n++) {
			if(n == X) continue;
			max = Math.max(max, timeToGO[n] + timeToBack[n]);
		}
		
		System.out.println(max);

	}

	private static void dijkstraBack(int startX) {

		boolean[] visit = new boolean[N + 1]; // 방문체크 배열

		PriorityQueue<NodeTown> pq = new PriorityQueue<>();
		pq.offer(new NodeTown(startX, 0));

		while (!pq.isEmpty()) {
			NodeTown now = pq.poll(); // 다음갈 노드

			if (!visit[now.num]) {

				visit[now.num] = true; // 방문처리해주고

				// 도착해야하는 마을이 아니라면 여기서 ㄱㄱ
				for (NodeTown next : list[now.num]) {
					if (timeToBack[next.num] > timeToBack[now.num] + next.time) {
						// 최단시간 갱신갱신
						timeToBack[next.num] = timeToBack[now.num] + next.time;
						pq.offer(new NodeTown(next.num, timeToBack[next.num]));
					}
				}
			}
		} // pq돌기
	}

	private static void dijkstra(int start) {

		boolean[] visit = new boolean[N + 1]; // 방문체크 배열

		PriorityQueue<NodeTown> pq = new PriorityQueue<>();
		pq.offer(new NodeTown(start, 0));

		int[] timeToX = new int[N + 1];
		Arrays.fill(timeToX, Integer.MAX_VALUE);
		timeToX[start] = 0; // 해당 시작은 0으로 하고 ㄱㄱ
		
		while (!pq.isEmpty()) {
			NodeTown now = pq.poll(); // 다음갈 노드

			if (!visit[now.num]) {

				visit[now.num] = true; // 방문처리해주고

				// 도착해야하는 마을이 아니라면 여기서 ㄱㄱ
				for (NodeTown next : list[now.num]) {
					if (timeToX[next.num] > timeToX[now.num] + next.time) {
						// 최단시간 갱신갱신
						timeToX[next.num] = timeToX[now.num] + next.time;
						pq.offer(new NodeTown(next.num, timeToX[next.num]));
					}
				}
				
				if (now.num == X) {
					// 도착해야하는 마을이라면 멈춰
					// 1번마을 시작점에 X까지 도달하는 timeToX를 넣어줘~!
					timeToGO[start] = timeToX[X];
					return;
				}
			}
		} // pq돌기
	}
}
