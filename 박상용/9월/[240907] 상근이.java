import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_2825_상근이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1024];
		long result = 0;

		for (int i = 0; i < N; i++) {
			int[] tmp = new int[10];
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++)
				tmp[s.charAt(j) - '0'] = 1;
			int num = 0;
			for (int j = 0; j < 10; j++) {
				if (tmp[j] > 0)
					num += Math.pow(2, j);
			}
			arr[num]++;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) { 
				if ((i & j) != 0)
					result += (long) arr[i] * arr[j];
			}
		}

		System.out.println((result - N) / 2);
	}
}
