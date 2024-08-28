package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 교차로 {

	static class Car implements Comparable<Car> {
		int idx;
		int time;
		int roadNum;

		Car(int idx, int time, int roadNum) {
			this.idx = idx;
			this.time = time;
			this.roadNum = roadNum;
		}

		public int compareTo(Car o) {
			return this.time - o.time;
		}
	}

	static int N;
	static int[] pass;
	static Queue<Car>[] road;
	static PriorityQueue<Car> waitingQ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		pass = new int[N];
		Arrays.fill(pass, -1);

		waitingQ = new PriorityQueue<>();
		road = new ArrayDeque[4];

		for (int i = 0; i < 4; i++) {
			road[i] = new ArrayDeque<>();
		}

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			int roadNum = st.nextToken().charAt(0) - 'A';

			waitingQ.add(new Car(n, time, roadNum));
		}

		int carTime = 0;

		while (true) {
			if (isAllRoadFull())
				break;

			addCarToRoad(carTime);
			passCar(carTime);

			if (waitingQ.isEmpty() && isRoadEmpty())
				break;

			if (!isRoadEmpty())
				carTime++;
			else
				carTime = waitingQ.peek().time;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(pass[i] + "\n");
		}

		System.out.println(sb.toString());

	}

	private static boolean isRoadEmpty() {
		for (int i = 0; i < 4; i++) {
			if (!road[i].isEmpty())
				return false;
		}
		return true;
	}

	private static void passCar(int carTime) {
		boolean[] isPassed = new boolean[4];

		for (int i = 0; i < 4; i++) {
			int next = (i + 3) % 4;

			if (road[next].isEmpty() && !road[i].isEmpty() && !isPassed[next]) {
				Car car = road[i].poll();
				pass[car.idx] = carTime;
				isPassed[i] = true;
			}
		}
	}

	private static void addCarToRoad(int carTime) {
		while (!waitingQ.isEmpty() && waitingQ.peek().time == carTime) {
			Car car = waitingQ.poll();
			road[car.roadNum].add(car);
		}
	}

	private static boolean isAllRoadFull() {
		for (int i = 0; i < 4; i++) {
			if (road[i].isEmpty())
				return false;
		}
		return true;
	}
}
