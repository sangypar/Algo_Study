import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1_12_1339_단어수학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[26]; //알파뱃 26
		for(int i =0 ; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < str.length(); j++) {
				char temp = str.charAt(j);
				arr[temp-'A'] += (int) Math.pow(10, str.length()-1 -j); //첫번째자리  두번째자리
				//A가 idx 0 , 3자리 일때 -> 100의자리 = 10^2 
			}
		}
		Arrays.sort(arr);//가장 큰 값이 뒤로 오게
		
		int num = 9; 
		int turn = 25;
		int ans = 0;
		while(arr[turn] != 0) { //없는 값나올때까지
			ans += arr[turn] * num;
			turn--;
			num--;
		}
		System.out.println(ans);
		
	}
}
