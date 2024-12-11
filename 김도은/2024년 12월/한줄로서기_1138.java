package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int[] answer = new int[N]; //최종 줄서기
		boolean[] seat = new boolean[N];
		
		for(int n = 0; n < N; n++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			int count = 0; // 앞에 몇 명이 있어야 하는지 카운트

            // "자기 앞에 num명이 있어야 한다"는 조건을 만족하는 자리를 찾기
            for (int i = 0; i < N; i++) {
                if (!seat[i]) {
                    if (count == num) {
                        answer[i] = n + 1;
                        seat[i] = true;
                        break;
                    }
                    count++;
                }
            }
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int n = 0; n < N; n++) {
			sb.append(answer[n]).append(" ");
		}
		
		System.out.println(sb);
		
	}
}
