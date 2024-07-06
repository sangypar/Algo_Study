// 몰라서 검색했어요...
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_성적평가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] scores = new int[4][N]; // 성적 저장
		int[][] contest = new int[4][3001]; // 참가자 수 저장
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int score = Integer.parseInt(st.nextToken());
				scores[i][j] = score;
				scores[3][j] += score;
				contest[i][score]++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int score = scores[0][i] + scores[1][i] + scores[2][i];
			contest[3][score]++;
		}
		
		int[][] sum = new int[4][3001];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 3000; j >= 0; j--) {
				if (j == 3000) sum[i][j] = contest[i][j];
				else sum[i][j] = sum[i][j + 1] + contest[i][j];
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				int score = scores[i][j];
				int order;
				
				if (score == 3000) order = 1;
				else order = sum[i][score + 1] + 1;
				
				sb.append(order).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}
