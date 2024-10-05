import java.util.Scanner;

// 백준 골드V, 집합의 표현
// Union Find
// 메모리 : 230,272KB, 시간 : 1,048ms
public class Main {

	static int parent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int op = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (op == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}

		System.out.println(sb);
		sc.close();
	}

	// union
	static void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		parent[parentX] = parentY;
	}

	// 부모 찾기
	static int find(int num) {
		if (parent[num] == num) {
			return num;
		}
		return parent[num] = find(parent[num]);
	}
}
