// 시간 초과가 발생하지 않는 이유
// 효율적인 시간 진행 (carTime 변수 관리): 이 코드에서는 시간 경과를 1초씩 증가시키지 않고, 가장 가까운 이벤트 시간으로 바로 이동합니다. 다음과 같은 두 가지 경우가 있습니다:

// waitingQ가 비어있지 않으면, 가장 빨리 도착할 차의 도착 시간 (waitingQ.peek().time)으로 carTime을 이동시킵니다.
// waitingQ가 비어있고, 모든 도로가 비어있으면 (isRoadEmpty()), 시뮬레이션이 종료됩니다.
// 이러한 방식으로 시간 carTime을 1초씩 증가시키는 것이 아니라, 이벤트가 발생하는 시점으로 "점프"하기 때문에 시간 효율성이 크게 향상됩니다.

// 우선순위 큐 (PriorityQueue)를 이용한 정렬: 차의 도착 시간을 기준으로 우선순위 큐 (waitingQ)를 사용하여 차를 정렬하고 관리합니다. 이로 인해 가장 빨리 도착하는 차의 시간에 맞춰 도로 상태를 업데이트할 수 있습니다. 시간 순서대로 차를 배치하므로, 매 초마다 모든 차를 검사할 필요가 없게 되어 성능이 향상됩니다.

// 도로 상태에 따라 동작 제어: 도로가 모두 차 있는 상태(isAllRoadFull() == true)일 때는 새로운 차가 도착해도 더 이상 추가할 수 없기 때문에 시뮬레이션이 종료됩니다. 반면에 도로에 빈 자리가 있거나 차가 통과할 수 있는 경우, 적절히 차를 도로에 추가하거나 통과시킵니다.

// 이벤트 기반으로 상태 업데이트: 이 코드는 매 반복마다 carTime에 도로에 추가할 차를 addCarToRoad(carTime)를 통해 추가하고, 도로에서 차량을 통과시킬 수 있는지 passCar(carTime)를 통해 확인합니다. 도로의 상태를 검사한 후 가장 빠른 이벤트 시점으로 이동하므로, 불필요한 시간 증가를 피합니다.

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
