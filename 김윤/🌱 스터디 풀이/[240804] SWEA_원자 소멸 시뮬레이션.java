import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_원자_소멸_시뮬레이션 {
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class Atom {
		int r;
		int c;
		int direction;

		int energy;
		public Atom(int r, int c, int direction, int energy) {
			this.r = r;
			this.c = c;
			this.direction = direction;
			this.energy = energy;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			List<Atom> atom = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				
				atom.add(new Atom(r, c, direction, energy));
			}
		}
	}
	
}
