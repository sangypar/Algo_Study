package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1]) {
					return Integer.compare(a[0], b[0]);
				}
				
				return Integer.compare(a[1], b[1]);
			}
		});
		
		int count = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) {
			if (meeting[i][0] >= end) {
				end = meeting[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
	
}
