import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_1120 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int Alen = A.length();
		int Blen = B.length();
		
		int answer = 51;
		
		for(int i = 0; i < Blen - Alen + 1; i++) { //B
			int tmp = 0;
			for (int j = 0; j < Alen; j++) { // A
				if(A.charAt(j) != B.charAt(i + j)) {
					tmp++;
				}
			}
			
			answer = Math.min(answer, tmp);
		}
		
		System.out.println(answer);
	}
}
