import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2110_공유기 설치
public class Main {
	
	static String S, T;
	static boolean ans = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 집의 개수
		int C = Integer.parseInt(st.nextToken());	// 공유기의 개수
		int[] houses = new int[N];
		
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);	// 좌표 정렬
		
		int min = 1;						// 최소 거리
		int max = houses[N-1] - houses[0];  // 최대 거리
		int ans = 0;						// 정답: 가장 인접한 두 공유기 사이의 거리 = 최대
		
		while (min <= max) {
            int start = houses[0];
            int mid = (min + max) / 2;
            int cnt = 1;

            // mid 만큼의 거리에서 설치할 수 있는 공유기 대수
            for (int i = 1; i < houses.length; i++) {
            	// 두 집 사이의 거리가 mid를 초과하는 경우: 공유기 설치 가능
            	// start 갱신, 공유기 개수++
                if (houses[i] - start >= mid) {
                    start = houses[i];
                    cnt++;
                }
            }

            // 설치 가능한 공유기 개수가 주어진 공유기 개수보다 큰 경우
            // mid 거리 유지 가능: min을 올리고 ans 갱신
            if (cnt >= C) { 	  // 거리가 좁거나 같은 경우
            	min = mid + 1;
                ans = mid;
            // 설치 가능한 공유기 개수가 주어진 공유기 개수보다 작은 경우
            // max 내리기
            } else {              
            	max = mid - 1; 
            }
        }
		
		System.out.println(ans);
	}
}
