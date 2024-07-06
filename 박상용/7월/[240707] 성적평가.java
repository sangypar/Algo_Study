import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_성적평가 { // 시간초과;;;;;;;;;오바야
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] score = new int[N][3];
		int[][] grade = new int[N][3];
		int[] totalscores = new int[N];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				score[j][i] = Integer.parseInt(st.nextToken());
				totalscores[j] += score[j][i];
			}
		}

		for (int i = 0; i < 3; i++) {
			int[] counting = new int[1001];
			for (int j = 0; j < N; j++) {
				counting[score[j][i]]++;
			}

			int gradenum = 1;
			for (int j = 1000; j >= 0; j--) {
				if (counting[j] != 0) {
					for (int k = 0; k < N; k++) {
						if (score[k][i] == j)
							grade[k][i] = gradenum;
					}
					gradenum += counting[j];
				}
			}
		}

		int[] totalgrade = new int[N];
		int[] counting = new int[3001];
		for (int i = 0; i < N; i++) {
			counting[totalscores[i]]++;
		}

		int gradenum = 1;
		for (int i = 3000; i >= 0; i--) {
			if (counting[i] > 0) {
				for (int j = 0; j < N; j++) {
					if (totalscores[j] == i)
						totalgrade[j] = gradenum;
				}
				gradenum += counting[i];
			}
		}

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < N; i++) {
				System.out.print(grade[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < N; i++) {
			System.out.print(totalgrade[i] + " ");
		}

	}
}
