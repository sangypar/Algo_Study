package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	
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
			sb.append(binarySearch(card, 0, N-1, number[i])).append(" ");
		}
		sb.append(binarySearch(card, 0, N-1, number[M-1]));
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] card, int start, int end, int key) {
		if (start > end) return 0;
		int mid = (start + end) / 2;
		
		if (card[mid] == key) return 1;
		else if (card[mid] > key) return binarySearch(card, start, mid - 1, key);
		else return binarySearch(card, mid + 1, end, key);
	}
	
}
