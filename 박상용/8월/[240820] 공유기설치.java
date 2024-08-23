import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class psy_2110_공유기설치 {
	static int N, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int result = bs(1, arr[N - 1] - arr[0]);
		System.out.println(result);
	}

	static int bs(int left, int right) {
		if (left >= right) {
			return left;
		}

		int mid = (left + right) / 2 + 1;
		int count = 1;

		int temp = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - temp >= mid) {
				count++;
				temp = arr[i];
				if (count >= C) {
					return bs(mid, right);
				}
			}
		}

		return bs(left, mid - 1);
	}
}
