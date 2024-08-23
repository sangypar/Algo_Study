import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String S, T;
	static boolean ans = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();
		
		check(S, T);
		
		if (ans) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void check(String S, String T) {
		while (T.length() > S.length()) {
			if (T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			} else if (T.charAt(T.length() - 1) == 'B') {
				T = new StringBuffer(T.substring(0, T.length() - 1)).reverse().toString();
			} else {
				break;
			}
		}
		
		if (T.equals(S)) {
			ans = true;
		}
	}
}
