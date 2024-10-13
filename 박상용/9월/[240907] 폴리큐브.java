import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class psy_2708_폴리큐브 {
	static class Cube {
		int r;
		int c;
		int z;

		public Cube(int r, int c, int z) {
			this.r = r; 
			this.c = c;
			this.z = z;
		}

		// 객체를 hash로 쓰려면 equals()와 hashCode() 메소드를 반드시 구현해야 해서 다음을 추가 (이걸 어케알아;;)
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Cube cube = (Cube) o;
			return r == cube.r && c == cube.c && z == cube.z;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c, z);
		}

	}

	static int[] dr = { 1, -1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Set<Cube> cubes;
	static Set<Cube> visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int P = Integer.parseInt(br.readLine());
			int[][] arr = new int[P][3];

			for (int k = 0; k < P / 8 + (P % 8 == 0 ? 0 : 1); k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8 && (k * 8 + j) < P; j++) {
					String[] cube = st.nextToken().split(",");
					arr[k * 8 + j][0] = Integer.parseInt(cube[0]);
					arr[k * 8 + j][1] = Integer.parseInt(cube[1]);
					arr[k * 8 + j][2] = Integer.parseInt(cube[2]);
				}
			}

			cubes = new HashSet<>();
			visited = new HashSet<>();
			int result = 0;

			for (int j = 0; j < P; j++) {
				cubes.add(new Cube(arr[j][0], arr[j][1], arr[j][2]));
				result += 6;

				for (int d = 0; d < 6; d++) {
					int nr = arr[j][0] + dr[d];
					int nc = arr[j][1] + dc[d];
					int nz = arr[j][2] + dz[d];
					Cube newcube = new Cube(nr, nc, nz);

					if (cubes.contains(newcube)) {
						result -= 2;
					}
				}
			}

			if (!bfs(arr[0], P)) {
				System.out.println("NO " + (visited.size() + 1));
			} else {
				System.out.println(result);
			}
		}
	}

	public static boolean bfs(int[] cube, int P) {
		Queue<int[]> q = new LinkedList<>();
		q.add(cube);
		visited.add(new Cube(cube[0], cube[1], cube[2]));

		while (!q.isEmpty()) {
			int[] cubecube = q.poll();
			for (int d = 0; d < 6; d++) {
				int nr = cubecube[0] + dr[d];
				int nc = cubecube[1] + dc[d];
				int nz = cubecube[2] + dz[d];
				Cube newcube = new Cube(nr, nc, nz);

				if (cubes.contains(newcube) && !visited.contains(newcube)) {
					visited.add(newcube);
					q.add(new int[] { nr, nc, nz });
				}
			}
		}
		return visited.size() == P;
	}
}
