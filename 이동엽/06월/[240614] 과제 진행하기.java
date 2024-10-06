import java.util.*;

// 프로그래머스_과제 진행하기_lv.2
// 남는 시간에 밀린 과제 빼서 하는게 오래 걸렸음.
// Class 만드는게 더 깔끔할둣.
class Solution {
	public List<String> solution(String[][] plans) {

		Arrays.sort(plans, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});

		List<String> answer = new ArrayList<>();
		Stack<String[]> stop = new Stack<>();
		int now = 0;

		for (int i = 0; i < plans.length - 1; i++) {
			String[] before = plans[i][1].split(":"); // 앞 과제
			String[] after = plans[i + 1][1].split(":"); // 뒤 과제
			
			// 시간 모두 분으로 환산
			int beforeStart = Integer.parseInt(before[0]) * 60 + Integer.parseInt(before[1]);
			int afterStart = Integer.parseInt(after[0]) * 60 + Integer.parseInt(after[1]);
			int time = Integer.parseInt(plans[i][2]);
			int end = beforeStart + time;
			
			// 앞 과제 끝나는 시간이 뒷 과제 시작시간보다 빠를 때
			if (end <= afterStart) {
				answer.add(plans[i][0]);
				now = end;
				
				// 밀린 과제 하기
				while (!stop.isEmpty() && now < afterStart) {
					String[] resume = stop.pop();
					int temp = afterStart - now;
					if (Integer.parseInt(resume[2]) <= temp) { // 밀린 과제를 해도 시간이 남을 때
						answer.add(resume[0]);
						now += Integer.parseInt(resume[2]);
					} else { // 밀린 과제 하기엔 시간 모자랄 때 쪼개서 과제 하기.
						resume[2] = String.valueOf(Integer.parseInt(resume[2]) - temp);
						stop.push(resume);
						now = afterStart;
					}
				}
			} else { // 앞에 과제를 하는 중 뒷 과제 시작시간이 될 때 남는 시간 스택에 넣기
				plans[i][2] = String.valueOf(end - afterStart);
				stop.push(plans[i]);
				now = afterStart;
			}
		} // for
		// 마지막 남은 과제 처리
		String[] last = plans[plans.length - 1];
		answer.add(last[0]);
		int end = Integer.parseInt(last[1].split(":")[0]) * 60 + Integer.parseInt(last[1].split(":")[1])
				+ Integer.parseInt(last[2]);

		while (!stop.isEmpty()) {
			String[] resume = stop.pop();
			answer.add(resume[0]);
		}

		return answer;
	}
}