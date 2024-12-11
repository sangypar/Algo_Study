package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 친구_1058 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] friend = new char[N][N];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			
			for(int c = 0; c < N; c++) {
				friend[r][c] = str.charAt(c);
			}
		}
		
		int max = 0;
		
		for(int r = 0; r < N; r++) {
			boolean[] visit = new boolean[N];

			int count = 0;
			
			for(int c = 0; c < N; c++) {
				
				if(r == c) continue; //자기자신이면 넘어가용
				
				if(friend[r][c] == 'Y') {
					
					if (!visit[c]) {
						visit[c] = true; //나랑 친구인지 체크
                        count++;
                    }
					
					//양쪽 공통 친구 찾기
					for(int h = 0; h < N; h++) {
						if(friend[c][h] == 'Y' && h != r && !visit[h]) {
							visit[h] = true;
							count++;
						}
					}
				}
			}
			
			max = Math.max(max, count);
		}

		System.out.println(max);
	}
}
