package baekjoon_gold;

import java.util.Scanner;

public class 집합의표현_1717 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 있는 집합 n+1개
		int m = sc.nextInt(); // 주어지는 연산 개수

		parent = new int[n + 1];
		// 집합은 n+1개 이고 해당 원소가 속한 집합의 대장 표시하는 배열

		for (int i = 0; i < n + 1; i++) {
			parent[i] = i; // 해당 원소 대장은 일단 나!
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			// 입력받는 연산
			int cal = sc.nextInt(); // 0은 합칩합 1은 포함확인
			int a = sc.nextInt(); // 원소1
			int b = sc.nextInt(); // 원소2

			if (cal == 0) {
				// 합칩합 연산
				union(a, b);
			} else {
				// 같은 집합인가요?
				if (isSame(a, b)) {
					// 같은 집합이라면
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}//입력끝
		
		System.out.println(sb);

	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			// 부모 찾아가보자고
			return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
		}
	}

	// 같은 부모 노드인지
	public static boolean isSame(int x, int y) {
		if (find(x) == find(y))
			return true;
		else
			return false;
	}
}
