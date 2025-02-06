package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //집의 개수
		int C = Integer.parseInt(st.nextToken()); //공유기 개수
		
		int[] homes = new int[N];
		
		for(int n = 0; n < N; n++) {
			homes[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(homes);
		
		int minDist = 1; //최소간격
		int maxDist = homes[N-1]; //최대간격
		
		while(minDist <= maxDist) {
			int mid = (minDist + maxDist) / 2;
			
			//여기에서 공유기 설치하는 로직이 굴러감.
			int start = 0;
			int count = 1;
			
			for(int n = 1; n < N; n++) {
				//이전 집이랑의 거리가 최소 거리보다 크면? 설치함
				if(homes[n] - homes[start] >= mid) {
					start = n;
					count++;
				}
			}
			
			if(count < C) {
				//공유기가 덜 설치됐으면
				maxDist = mid - 1;
			} else {
				//너무 많이 설치됐으면
				minDist = mid + 1;
			}
		}
		
		System.out.println(minDist - 1);
		
	}
}
