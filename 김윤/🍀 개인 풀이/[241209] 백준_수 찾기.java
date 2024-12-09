package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		int[] array;
		int[] number;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		M = Integer.parseInt(br.readLine());
		number = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(array, 0, N-1, number[i]));
		}
	}
	
	static int binarySearch(int[] array, int start, int end, int key) {
		if (start > end) return 0;
		int mid = (start + end) / 2;
		
		if (array[mid] == key) return 1;
		else if (array[mid] > key) return binarySearch(array, start, mid - 1, key);
		else return binarySearch(array, mid + 1, end, key);
	}
	
}
