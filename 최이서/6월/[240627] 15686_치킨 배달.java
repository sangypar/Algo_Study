import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	
	static int min = Integer.MAX_VALUE;
	static List<int[]> house, store;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// N X N
		M = Integer.parseInt(st.nextToken());	// 최대 M개의 치킨집 선택
		
		house = new LinkedList<>();
		store = new LinkedList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num == 1) {
					house.add(new int[] {r, c});
				} else if (num == 2) {
					store.add(new int[] {r, c});
				}
			}
		}
		
		comb(0, 0, new int[M]);
		System.out.println(min);
	}

	// M개의 치킨집 조합
	private static void comb(int start, int depth, int[] selected) {
		
		if (depth == M) {
			calc(selected);
			return;
		}
		
		for (int i = start; i < store.size(); i++) {
			selected[depth] = i;
			comb(i+1, depth+1, selected);
		}
	}

	private static void calc(int[] selected) {
		
		int sum = 0;

		// 전체 집들에 대하여
		for (int[] h : house) {
			
			int minDis = Integer.MAX_VALUE;
			
			// 선택된 치킨집까지의 최소거리 탐색
			for (int idx : selected) {
				int[] s = store.get(idx);
				int dis = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
				minDis = Math.min(minDis, dis);
			}
			
			sum += minDis;
		}
		
		if (sum < min)
			min = sum;
	}
}