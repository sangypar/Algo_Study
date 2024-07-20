class Solution {
	public int solution(String[][] book_time) {
		int[] arr = new int[1450]; // 시간 배열

		for (int i = 0; i < book_time.length; i++) {
			String[] start = book_time[i][0].split(":"); // 시작 
			String[] end = book_time[i][1].split(":"); // 끝
			int starttime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]); 
			int endtime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])+10;
			arr[starttime]++;
			arr[endtime]--;
		}

		int answer = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
			answer = Math.max(answer, arr[i]);
		}

		return answer;
	}
}