import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class psy_15686_치킨배달 {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, result;
	static boolean[] open;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Node> house = new ArrayList<>();
		List<Node> chicken = new ArrayList<>();
		int housecnt = 0, chickencnt = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					house.add(new Node(r, c));
					housecnt++;
				} else if (num == 2) {
					chicken.add(new Node(r, c));
					chickencnt++;
				}
			}
		}

		arr = new int[housecnt][chickencnt];

		for (int r = 0; r < housecnt; r++) {
			for (int c = 0; c < chickencnt; c++) {
				arr[r][c] = Math.abs(house.get(r).r - chicken.get(c).r) + Math.abs(house.get(r).c - chicken.get(c).c);
			}
		}

		open = new boolean[chickencnt];
		result = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(result);

	}

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			cal();
			return;
		}
		if (idx == open.length) {
			return;
		}
		open[idx] = true;
		comb(idx + 1, cnt + 1);
		open[idx] = false;
		comb(idx + 1, cnt);
	}

	private static void cal() {
		int cost = 0;
		for (int r = 0; r < arr.length; r++) {
			int housetochicken = Integer.MAX_VALUE;
			for (int c = 0; c < arr[r].length; c++) {
				if (open[c])
					housetochicken = Math.min(housetochicken, arr[r][c]);
			}
			cost += housetochicken;
		}
		result = Math.min(result, cost);
	}
}
