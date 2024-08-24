import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long total = 0;
		long sum = 0;

		for (int i = 0; i < queue1.length; i++) {
			total += queue1[i];
			total += queue2[i];
			sum += queue1[i];
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		int max = queue1.length * 4;
		total /= 2;
		int result = 0;

		while (sum != total) {

			if (max == 0) {
				return -1;
			}

			if (sum > total) {
				int tmp = q1.poll();
				sum -= tmp;
				q2.add(tmp);
			} else {
				int tmp = q2.poll();
				sum += tmp;
				q1.add(tmp);
			}

			max--;
			result++;
		}

		return result;
	}
}