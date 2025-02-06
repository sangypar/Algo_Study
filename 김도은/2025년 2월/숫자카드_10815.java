package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드_10815 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 상근이 카드개수
		int[] cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			cards[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards); // 정럴해두기

		int M = Integer.parseInt(br.readLine()); // 주어지는 정수
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());

			boolean isSearch = searchNum(num, cards);
			
			if (isSearch) {
			    sb.append(1).append(" ");
			} else {
			    sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean searchNum(int num, int[] cards) {

		int left = 0;
		int right = cards.length - 1;

		while (left <= right) {
			
			int mid = (left + right) / 2;
			
			if(cards[mid] < num) left  = mid + 1;
			else if(cards[mid] > num) right = mid - 1;
			else return true; //찾음
		}

		return false;
	}
}
