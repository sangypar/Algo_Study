package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_108116_숫자카드2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		int[] card;
		int[] number;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		M = Integer.parseInt(br.readLine());
		number = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M-1; i++) {
			int lower = lowerBound(card, number[i]);
			int upper = upperBound(card, number[i]);
			sb.append(upper - lower).append(" ");
		}
		sb.append(upperBound(card, number[M-1]) - lowerBound(card, number[M-1]));
		
		System.out.println(sb);
	}
	
	static int lowerBound(int[] card, int key) {
		int start = 0;
		int end = card.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			if (card[mid] >= key) end = mid;
			else start = mid + 1;
		}
		
		return start;
	}
	
	static int upperBound(int[] card, int key) {
		int start = 0;
		int end = card.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			if (card[mid] > key) end = mid;
			else start = mid + 1;
		}
		
		return start;
	}
}
