import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class psy_1744_수묶기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		List<Integer> arr = new ArrayList<>();
		int lowcnt = 0, highcnt = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 1) {
				result++;
				continue;
			} else if (num < 1)
				lowcnt++;
			else
				highcnt++;
			arr.add(num);
		}

		Collections.sort(arr);
		for (int i = 1; i < lowcnt; i++)
			result += arr.get(i - 1) * arr.get(++i - 1);
		for (int i = 1; i < highcnt; i++)
			result += arr.get(arr.size() - i) * arr.get(arr.size() - ++i);
		if (lowcnt % 2 == 1)
			result += arr.get(lowcnt - 1);
		if (highcnt % 2 == 1)
			result += arr.get(arr.size() - highcnt);
		System.out.println(result);

	}
}
