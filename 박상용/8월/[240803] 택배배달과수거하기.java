import java.util.Arrays;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		int[] sum1 = new int[n];
		int[] sum2 = new int[n];
		int[] sum3 = new int[n];

		sum1[n - 1] = deliveries[n - 1];
		sum2[n - 1] = pickups[n - 1];
		sum3[n - 1] = (int) Math.ceil(Math.max(sum1[n - 1], sum2[n - 1]) / (double) cap);
		for (int i = n - 2; i >= 0; i--) {
			sum1[i] = sum1[i + 1] + deliveries[i];
			sum2[i] = sum2[i + 1] + pickups[i];
			sum3[i] = (int) Math.ceil(Math.max(sum1[i], sum2[i]) / (double) cap);
		}
		long answer = 0;
		int tmp = 0;
		for (int i = n - 1; i >= 0; i--) {
			answer += (sum3[i] - tmp) * (i + 1);
			tmp = sum3[i];
		}

		return answer * 2;
	}
}