package level2;

import java.util.Arrays;
import java.util.Scanner;

public class 이모티콘할인행사 {

	static int sign = 0; //가입수
	static int earn = 0; //수익률

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] users = { { 40, 10000 }, { 25, 10000 } }; // 사용자

		int[] emoticons = { 7000, 9000 }; // 이모티콘 가격

		int[] answer = solution(users, emoticons);
		
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int[][] users, int[] emoticons) {

		int[] answer = new int[2];

		int[] arr = new int[emoticons.length];

		comb(arr, 0, users, emoticons); //조합을 돌립니다.

		answer[0] = sign;
		answer[1] = earn;

		return answer;
	}

	private static void comb(int[] arr, int start, int[][] users, int[] emoticons) {

		if (start == arr.length) { //모든 조합을 다 만들었으면
			calculate(arr, users, emoticons); //계산해줘
			return;
		}

		for (int i = 10; i <= 40; i += 10) {
			//10 20 30 40씩 넣어주고 조합계속 돌려봄
			arr[start] = i;
			comb(arr, start + 1, users, emoticons);
		}

	}

	private static void calculate(int[] arr, int[][] users, int[] emoticons) {
		int count = 0; //이모티콘플러스 가입자
		int income = 0; //수입률

		for (int[] user : users) {
			int discount = user[0]; //할인율
			int price = user[1]; //가격 기준 - 이모티콘 플러스 가입기준
			
			int sum = 0; //구매가격

			//해당 유저에 대해서 이모티콘 수익률
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= discount) {
					//내가 구매해야하는 기준 할인율보다 현재 할인중인 진짜 할인율이 크거나 같으면 구매함
					sum += (emoticons[i] / 100) * (100 - arr[i]);
				}
			}

			if (sum >= price) {
				//플러스 가입이 나을듯하면 가입
				count++;
			} else {
				//아니면 수입률
				income += sum;
			}
		}//유저들을 도는거 끝

		if (count > sign) { //가입자가 한명이라도 있으면
			//해당 가입자 + 수입으로 처리
			sign = count;
			earn = income;
			return;
		} else if (count == sign) {
			//가입자가 없다면?
			if (earn < income) {
				//수익률 출력
				earn = income;
			}
		}
	}
}
