import java.util.*;

public class BJ2573_빙산 {
	
	// 1. 2차원 배열 입력
	// 2. 빙산이 녹는 메서드 구현 
	// 3. 빙산이 전부 녹았는지 확인하는 메서드 구현 
	// 4. 빙산이 분리됐는지 확인하는 메서드 구현 
	
	static int n, m;
	static int[][] glacier;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		glacier = new int[n][m];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				glacier[r][c] = sc.nextInt();
			}
		}
		
		int year = 0;
		
		do {
			year++;
			melting();
			
			if(isNone()) {
				year = 0;
				break;
			}
			
		} while(isSeperated());
		
		System.out.println(year);
	}
	
	// 빙하 녹이기
	// 1. 빙하를 새로운 배열에 복사한 뒤  
	// 2. 접한 바다의 면 만큼 녹인다 
	static void melting() {
		int[][] beforeGlacier = new int[n][m];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for(int r = 0; r < n; r++) {
			beforeGlacier[r] = Arrays.copyOf(glacier[r], m);
		}
		
		for(int r = 1; r < n-1; r++) {
			for(int c = 1; c < m-1; c++) {
				// 빙하가 있는 경우만 확인 
				if(beforeGlacier[r][c] > 0) {
					// 바다와 빙하가 접한 면의 수를 카운트해서 기존 빙하의 위치에 빼주기 
					int cnt = 0;
					
					for(int d = 0; d < 4; d++) {
						int nr = dr[d] + r;
						int nc = dc[d] + c;
						
						if(beforeGlacier[nr][nc] == 0) cnt++;
					}
					
					glacier[r][c] -= cnt;
					if(glacier[r][c] < 0) glacier[r][c] = 0;
				}
			}
		}
	}
	
	// 빙하가 분리되기 전에 다 녹았는가? 
	static boolean isNone() {
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(glacier[r][c] > 0) return false;
			}
		}
		
		return true;
	}
	
	// 빙하가 분리되었는가?
	// 1. visited 배열에 바다인 곳은 true 처리
	// 2. 처음으로 빙하가 나오는 곳의 좌표를 저장
	// 3. 그 좌표를 시작으로 인접한 빙하 전부 visited true 처리 
	// 4. 그래도 visited 배열에 false가 남아있다면 빙하가 분리된 것
	static boolean isSeperated() {
		visited = new boolean[n][m];
		
		int startR = -1;
		int startC = -1;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(glacier[r][c] == 0) visited[r][c] = true;
				
				else if(startR == -1 && startC == -1) {
					startR = r;
					startC = c;
				}
			}
		}
		
		if(checkSeperated(startR, startC)) return true;
		
		return false;
	}
	
	// 빙하의 처음 좌표에서 인접한 좌표 전부 확인 후
	// 여전히 남은 빙하가 있는지 확인 
	static boolean checkSeperated(int startR, int startC) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		queue.add(new int[]{startR, startC});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				
				if(glacier[nr][nc] > 0 && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(!visited[r][c]) return false;
			}
		}
		
		return true;
	}
	
}
