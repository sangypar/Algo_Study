import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class psy_5972_택배배송 { // 메모리 초과 떴어요
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int hutgan1 = Integer.parseInt(st.nextToken());
			int hutgan2 = Integer.parseInt(st.nextToken());
			int cow = Integer.parseInt(st.nextToken());
			arr[hutgan1][hutgan2] = cow;
			arr[hutgan2][hutgan1] = cow;
		}

		boolean[] visited = new boolean[N + 1];
		int[] result = new int[N + 1];

		Arrays.fill(result, Integer.MAX_VALUE);
		result[1] = 0;
		visited[1] = true;
		int now = 1;

		while (true) {
			int min = Integer.MAX_VALUE;

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[now][i] != Integer.MAX_VALUE)
					result[i] = Math.min(result[i], result[now] + arr[now][i]);
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && result[i] < min) {
					min = result[i];
					now = i;
				}
			}

			visited[now] = true;

			if (now == N)
				break;
		}

		System.out.println(result[N]);

	}
}
