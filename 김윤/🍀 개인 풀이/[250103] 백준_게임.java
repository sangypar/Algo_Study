package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1072_게임 {
	
	static int X, Y, Z;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (int) ((long)Y * 100 / X);
		
		System.out.println(binarySearch(1, 1_000_000_000));
	}
	
	static int binarySearch(int start, int end) {
		int result = -1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int rate = (int) ((long)(Y + mid) * 100 / (X + mid));
			
			if (rate > Z) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return result;
	}
	
}
