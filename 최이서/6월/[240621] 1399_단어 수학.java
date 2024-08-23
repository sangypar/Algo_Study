import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 백준1339_단어 수학
class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		Integer[][] sum = new Integer[26][26];
		
		for (int i = 0; i < 26; i++) {
			sum[i][0] = i;
			sum[i][1] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str;
			for (int j = 0; j < str.length(); j++) {
				sum[str.charAt(j) - 65][1] += (int)Math.pow(10, str.length()-j-1);
			}
		}

		Arrays.sort(sum, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o2[1] - o1[1];
			}
		});

		int[] alphabet = new int[26];
		int num = 9;
		
		for (int i = 0; i < 26; i++) {
			alphabet[sum[i][0]] = num--;
		}
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			int len = arr[i].length();
			String s = arr[i];
			
			for (int l = 0; l < len; l++) {
				ans += alphabet[s.charAt(l) - 65] * Math.pow(10, len-l-1);
			}
		}
		
		System.out.println(ans);
	}
}