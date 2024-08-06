import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int num;
	int dis;

	public Point(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
}

public class Main {

	static int N;
	static int[] min;
	static List<List<Point>> cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 		// N개의 헛간
		int M = Integer.parseInt(st.nextToken()); 	// M개의 양방향 길

		min = new int[N + 1];
		Arrays.fill(min, 987654321);
		
		cost = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			cost.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());	// 거리

			cost.get(A).add(new Point(B, d));
			cost.get(B).add(new Point(A, d));
		}

		BFS();
		System.out.println(min[N]);
	}

	private static void BFS() {
		
		PriorityQueue<Point> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dis, o2.dis));
		Q.add(new Point(1, 0));
		min[1] = 0;

		while (!Q.isEmpty()) {
			Point pt = Q.poll();

			if(min[pt.num] < pt.dis)
				continue;
			
			for (Point nextPt : cost.get(pt.num)) {
				if (min[nextPt.num] > pt.dis + nextPt.dis) {
					min[nextPt.num] = pt.dis + nextPt.dis;
					Q.add(new Point(nextPt.num, min[nextPt.num]));
				}
			}
		}
	}
}
