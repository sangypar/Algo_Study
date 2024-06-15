import java.util.*;

public class PRGMS_과제진행하기 {

// 1. 시간을 전부 분으로 바꾸기
// 2. plans 배열을 시작 시간이 빠른 순으로 정렬하기
// 3. 먼저 끝나는 순서대로 과제 이름 정렬하기

	public String[] solution(String[][] plans) {

		// 1. 시간을 전부 분으로 바꾸기
		for (int i = 0; i < plans.length; i++) {
			String minString = "";
			minString += String.valueOf(plans[i][1].charAt(0));
			minString += String.valueOf(plans[i][1].charAt(1));

			int min = Integer.parseInt(minString) * 60;

			minString = "";
			minString += String.valueOf(plans[i][1].charAt(3));
			minString += String.valueOf(plans[i][1].charAt(4));

			min += Integer.parseInt(minString);

			plans[i][1] = String.valueOf(min);
		}

		// 2. plans 배열을 시작 시간이 빠른 순으로 정렬하기
		Arrays.sort(plans, Comparator.comparing(a -> Integer.parseInt(a[1])));

		// 3. 먼저 끝나는 순서대로 과제 이름 정렬하기
		StringBuilder sb = new StringBuilder();
		Stack<String[]> stack = new Stack<>();

		for (int i = 0; i < plans.length - 1; i++) {
			int currTime = Integer.parseInt(plans[i][1]);
			int playTime = Integer.parseInt(plans[i][2]);
			int nextTime = Integer.parseInt(plans[i + 1][1]);

			// 시간 충분한 경우
			if (currTime + playTime <= nextTime) {
				sb.append(plans[i][0]).append(",");
				currTime += playTime;

				// 시간 남으면 stack에 남아있는 과제 마저 진행
				while (!stack.isEmpty() && currTime < nextTime) {
					String[] remainTask = stack.pop();
					int freeTime = nextTime - currTime;
					int remainTime = Integer.parseInt(remainTask[1]);

					// 남은 과제 끝낼 수 있다면
					if (remainTime <= freeTime) {
						sb.append(remainTask[0]).append(",");
						currTime += remainTime;

						// 끝낼 만큼의 시간은 아니라면
					} else {
						stack.push(new String[] { remainTask[0], String.valueOf(remainTime - freeTime) });
						currTime = nextTime;
						break;
					}
				}

				// 시간 모자란 경우
			} else {
				int remainTime = currTime + playTime - nextTime;
				stack.push(new String[] { plans[i][0], String.valueOf(remainTime) });
			}
		}

		// 마지막 과제 처리
		sb.append(plans[plans.length - 1][0]).append(",");

		// 스택에 남아있는 과제 순서대로 처리
		while (!stack.isEmpty()) {
			sb.append(stack.pop()[0]).append(",");
		}

		String result = sb.toString();
		String[] answer = result.substring(0, result.length() - 1).split(",");
		return answer;
	}
}
