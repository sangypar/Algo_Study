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

public class Main_2708 {

	static int[][] directions = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int P = Integer.parseInt(br.readLine());
			Set<String> cubeSet = new HashSet<>();
			List<int[]> cubes = new ArrayList<>();
			
			for (int i = 0; i < P; i++) {
				String[] line = br.readLine().split(" ");
				
				for (String number : line) {
					if (!number.contains(",")) continue;
					String[] numbers = number.split(",");
					
					if (numbers.length != 3) continue;
					int x = Integer.parseInt(numbers[0]);
					int y = Integer.parseInt(numbers[1]);
					int z = Integer.parseInt(numbers[2]);
					
					cubes.add(new int[] {x, y, z});
					cubeSet.add(x + "," + y + "," + z);
				}
			}
			
			if (!isPolyCube(cubes, cubeSet)) {
				System.out.println("NO");
				continue;
			}
			
			int surfaceArea = calculateArea(cubes, cubeSet);
			System.out.println(surfaceArea);
		}
	}

	static boolean isPolyCube(List<int[]> cubes, Set<String> cubeSet) {
		Set<String> visit = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(cubes.get(0));
		visit.add(cubes.get(0)[0] + "," + cubes.get(0)[1] + "," + cubes.get(0)[2]);

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nx = current[0] + direction[0];
				int ny = current[1] + direction[1];
				int nz = current[2] + direction[2];
				String next = nx + "," + ny + "," + nz;

				if (cubeSet.contains(next) && !visit.contains(next)) {
					visit.add(next);
					queue.add(new int[] { nx, ny, nz });
				}
			}
		}

		return visit.size() == cubes.size();
	}

	static int calculateArea(List<int[]> cubes, Set<String> cubeSet) {
		int totalArea = 0;

		for (int[] cube : cubes) {
			int x = cube[0], y = cube[1], z = cube[2];
			int side = 6;

			for (int[] direction : directions) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				int nz = z + direction[2];
				String adj = nx + "," + ny + "," + nz;

				if (cubeSet.contains(adj))
					side--;
			}

			totalArea += side;
		}

		return totalArea;
	}

}
