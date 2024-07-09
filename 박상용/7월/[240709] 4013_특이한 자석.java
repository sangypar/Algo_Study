import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class psy_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			int k = Integer.parseInt(br.readLine());
			Deque<Integer>[] arr = new ArrayDeque[4];
			for (int j = 0; j < 4; j++) {
				arr[j] = new ArrayDeque<>();
			}

			for (int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int l = 0; l < 8; l++) {
					arr[j].add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				int[] tmp = new int[8];
				for (int l = 0; l < 8; l++) {
					tmp[l] = get(arr[l / 2], l % 2 == 0 ? 6 : 2);
				}

				int tmpdir = dir;

				rotate(arr[idx], dir);

				for (int left = idx; left > 0; left--) {
					if (tmp[left * 2] != tmp[(left - 1) * 2 + 1]) {
						tmpdir *= -1;
						rotate(arr[left - 1], tmpdir);
					} else
						break;
				}

				tmpdir = dir;

				for (int right = idx; right < 3; right++) {
					if (tmp[right * 2 + 1] != tmp[(right + 1) * 2]) {
						tmpdir *= -1;
						rotate(arr[right + 1], tmpdir);
					} else
						break;
				}

			}
			int result = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[j].getFirst() == 1)
					result += Math.pow(2, j);
			}
			System.out.println("#"+i+" "+result);

		}
	}

	private static int get(Deque<Integer> deque, int i) {
		Iterator<Integer> iterator = deque.iterator();
		int now = 0;
		while (iterator.hasNext()) {
			int result = iterator.next();
			if (now == i) {
				return result;
			}
			now++;
		}
		throw new IndexOutOfBoundsException();
	}

	private static void rotate(Deque<Integer> deque, int dir) {
		if (dir == 1) {
			int out = deque.pollLast();
			deque.offerFirst(out);
		} else {
			int out = deque.pollFirst();
			deque.offerLast(out);
		}
	}
}
