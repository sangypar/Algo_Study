import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dpZero = new int[41];
	static int[] dpOne = new int[41];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		setDp();

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			System.out.println(dpZero[N] + " " + dpOne[N]);
		}

	}

	private static void setDp() {
		// 초기값 설정
		dpZero[0] = 1;
		dpOne[0] = 0;
		dpZero[1] = 0;
		dpOne[1] = 1;

		for (int i = 2; i < 41; i++) {

			dpZero[i] = dpZero[i - 1] + dpZero[i - 2];
			dpOne[i] = dpOne[i - 1] + dpOne[i - 2];

		}
	}
}
