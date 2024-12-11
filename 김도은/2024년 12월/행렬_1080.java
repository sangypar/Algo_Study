package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_1080 {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			
			for(int c = 0; c < M; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			
			for(int c = 0; c < M; c++) {
				arr2[r][c] = str.charAt(c) - '0';
			}
		}
		
		int count = 0;
		
		// 3x3 변환 가능한 부분에 대해 반복
        for (int r = 0; r <= N - 3; r++) {
            for (int c = 0; c <= M - 3; c++) {
                if (arr[r][c] != arr2[r][c]) {
                    change(arr, r, c); // 3x3 부분 뒤집기
                    count++;
                }
            }
        }
		
        // 변환이 끝난 후 두 행렬 비교
        if (check(arr, arr2)) {
            System.out.println(count);
        } else {
            System.out.println(-1); // 변환할 수 없는 경우
        }
		
	}

	private static int[][] change(int[][] arr, int R, int C) {
		
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(arr[R + r][C + c] == 0) arr[R + r][C + c] = 1;
				else arr[R + r][C + c] = 0;
			}
		}
		
		return arr;
		
	}

	private static boolean check(int[][] arr, int[][] arr2) {
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(arr[r][c] != arr2[r][c]) return false;
			}
		}
		
		return true;
	}
}
