package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 폴리큐브의겉넓이_2708 {

	static int[][] directions = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 개수

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine()); // 점의 개수
			List<String> cubes = new ArrayList<>(); // 좌표 저장을 위한 List

			// 좌표를 읽어오기
			int line = P / 8; // 각 줄에 최대 8개의 좌표가 주어지므로 필요한 줄 수 계산

			for (int i = 0; i < line; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					String now = st.nextToken();
					cubes.add(now); // 각 좌표를 리스트에 추가
				}
			}

			if (P % 8 > 0) {
				// 더 출력되면
				StringTokenizer st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					String now = st.nextToken();
					cubes.add(now); // 각 좌표를 리스트에 추가
				}
			}

			// 폴리큐브 여부 확인 및 겉넓이 계산
			String result = findPolyCube(cubes);
			sb.append(result).append("\n");
		}

		System.out.println(sb);

	}

	private static String findPolyCube(List<String> cubes) {
		int surface = 0;
		int idx = 0;

		for (String cube : cubes) {
			String[] points = cube.split(",");

			int x = Integer.parseInt(points[0]);
			int y = Integer.parseInt(points[1]);
			int z = Integer.parseInt(points[2]);

			int first = 6; // 초기면접

			for (int[] dir : directions) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				int nz = z + dir[2];
				String next = nx + "," + ny + "," + nz;

				// 붙어있는 애가 있따 하믄
				if (cubes.contains(next)) {
					first--; // 하나씩 면접 감소
				}
			}

			surface += first;
		}

		// 연결성 검사 및 끊긴 정육면체 번호 확인
		idx = isConnect(cubes);
		
		if (idx != -1) {
			return "NO " + (idx + 1); // 연결이 끊긴 정육면체의 번호 (1부터 시작)
		}

		return String.valueOf(surface);
	}

	private static int isConnect(List<String> cubes) {

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		// 시작 큐브를 큐에 추가하고 방문 표시
		String startCube = cubes.get(0);
		queue.offer(startCube);
		visited.add(startCube);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			String[] parts = current.split(",");

			int x = Integer.parseInt(parts[0]);
			int y = Integer.parseInt(parts[1]);
			int z = Integer.parseInt(parts[2]);

			// 6방향으로 이웃을 검사
			for (int[] dir : directions) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				int nz = z + dir[2];
				String next = nx + "," + ny + "," + nz;

				// 이웃해 있는데, 방문하지 않았다면....
				if (cubes.contains(next) && !visited.contains(next)) {
					queue.offer(next);
					visited.add(next);
				}
			}
		}

        // 모든 큐브가 방문되었는지 확인
        if (visited.size() == cubes.size()) {
            return -1; // 모두 연결된 경우
        }

        // 연결이 끊긴 정육면체의 번호를 찾기
        for (int i = 0; i < cubes.size(); i++) {
            if (!visited.contains(cubes.get(i))) {
                return i; // 연결이 끊긴 첫 번째 정육면체의 인덱스 반환
            }
        }

        return -1; // 기본 반환 값 (여기에 도달하지 않아야 함)
	}
}
