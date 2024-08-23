import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class psy_원자소멸시뮬레이션 {
	static class Node {
		int r;
		int c;
		int d;
		int energy;
		boolean flag;

		public Node(int r, int c, int d, int energy, boolean flag) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.energy = energy;
			this.flag = flag;
		}

	}

	static class Memo {
		int r;
		int c;

		public Memo(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;

			List<Node> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Node(Integer.parseInt(st.nextToken()) * 2, Integer.parseInt(st.nextToken()) * 2,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true));
			}
			int[][] arr = new int[4002][4002];

			while (true) {
				boolean out = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).flag) {
						list.get(j).r += dr[list.get(j).d];
						list.get(j).c += dc[list.get(j).d];
						if (list.get(j).r < -2000 || list.get(j).r > 2000 || list.get(j).c < -2000
								|| list.get(j).c > 2000) {
							list.get(j).r = 0;
							list.get(j).c = 0;
							list.get(j).flag = false;
						} else
							out = true;
					}
				}

				if (!out)
					break;

				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).flag) {
						arr[list.get(j).r + 2000][list.get(j).c + 2000]++;
					}
				}

				List<Memo> list2 = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).flag && arr[list.get(j).r + 2000][list.get(j).c + 2000] > 1) {
						result += list.get(j).energy;
						list.get(j).flag = false;
						list2.add(new Memo(list.get(j).r + 2000, list.get(j).c + 2000));
					}
				}

				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).flag) {
						arr[list.get(j).r + 2000][list.get(j).c + 2000] = 0;
					}
				}

				while (!list2.isEmpty()) {
					arr[list2.get(0).r][list2.get(0).c] = 0;
					list2.remove(0);
				}
			}

			System.out.println("#" + i + " " + result);

		}
	}
}
