package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
	
	static int[] wifi;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 집의개수
		int C = Integer.parseInt(st.nextToken()); // 공유기수

		wifi = new int[N];

		for (int n = 0; n < N; n++) {
			wifi[n] = Integer.parseInt(br.readLine());
		} //입력 완
		
		Arrays.sort(wifi); //정렬해야 이분탐색가능
		
		int minDist = 1; //최소 거리
		int maxDist = wifi[N-1] - wifi[0] + 1; //최소 거리가 가질 수 있는 최대값
		
		while(minDist < maxDist) {
			//최소거리가 아직 작다면
			
			int mid = (minDist + maxDist) / 2;
			
			if(canInstall(mid) < C) {
				maxDist = mid;
			} else {
				minDist = mid + 1;
			}
		}
		
		System.out.println(minDist - 1);
	}

	private static int canInstall(int mid) {
		
		//첫 집은 무조건 설치한다고 가정
		int count = 1;
		int lastWifi = wifi[0]; //최종인덱스
		
		for(int i = 1; i < wifi.length; i++) {
			int locate = wifi[i];
			
			if(locate - lastWifi >= mid) {
				count++;
				lastWifi = locate;
			}
		}
		
		return count;
	}
}
