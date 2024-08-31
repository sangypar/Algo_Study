package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자동차테스트 {
	
	static int N;
	static int[] car;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 자동차 개수
		int Q = Integer.parseInt(st.nextToken()); // 테스트 개수

		car = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			car[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(car); // 정렬일단해줘~~

		StringBuilder sb = new StringBuilder();

		for (int q = 0; q < Q; q++) {
			int mid = Integer.parseInt(br.readLine()); // 찾을 중앙값

			int idx = findIdx(mid); // 해당값이 몇번째 인덱스인지 찾자
			
			if(idx == -1) {
				//없는 숫자라면?
				sb.append(0).append("\n");
				continue;
			}

			int left = idx; //왼쪽에 있는 자동차 수
			int right = N - idx - 1; //오른쪽에 있는 자동차 수
			
			sb.append(left * right).append("\n");
		}
		
		System.out.println(sb);

	}

	private static int findIdx(int mid) {
		
		for(int n = 0; n < N; n++) {
			if(car[n] == mid) return n;
		}
		
		return -1;
	}
}
