import java.util.Arrays;
import java.util.Scanner;

// 백준1339 단어 수학, GoldIV 
// GREEDY
// 메모리 : 12,912KB, 시간 : 112ms
// 1. 알파벳을 0 ~ 9 의 숫자로 생각
// 2-1. 10의 거듭제곱 * 알파벳의 갯수를 세줌. ex) GCF = 100G+10C+F, ACDEB = 10,000A+1,000C+100D+10E+B
// 2-2. 예시는 10,000A+1010C+100G+100D+10E+B+F
// 3. 갯수가 많은 순으로 정렬 후 9-- 곱해서 더해줌.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] alp = new int[26];

		while (N-- > 0) {
			String str = sc.next();
			int len = str.length();
			// 2번을 구현한 로직, A = 65
			// 길이가 N이면 최대는 10^(N-1)이 된다.
			// ex) 세자리수 일 경우 : 100 (10^2)
			for (int i = 0; i < len; i++) {
				alp[str.charAt(i) - 65] += (int) Math.pow(10, len - i - 1);
			}
		}
		Arrays.sort(alp);

		int sum = 0;
		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (alp[i] == 0) {
				break;
			}
			sum += alp[i] * num--;
		}

		System.out.println(sum);
		sc.close();
	}
}