package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

///////////////////////참고로 이번 풀이는 구글링을 통해 얻은 결론이므로 안 보고 다시 풀어보자 ////////////////////////

//과제계획 클래스
class Plan {
	String name; //과목명
	int start; //시작시간
	int playTime; //걸리는시간

	public Plan(String name, String start, String playTime) {
		this.name = name;
		String[] time = start.split(":");
		this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		this.playTime = Integer.parseInt(playTime);
	}

	//끝나는 시간 구하기
	public int endTime() {
		return start + playTime;
	}
}

class 과제진행하기 {
	public String[] solution(String[][] plans) {
		
		Plan[] studyplans = new Plan[plans.length];
		
		for (int i = 0; i < plans.length; i++) {
			studyplans[i] = new Plan(plans[i][0], plans[i][1], plans[i][2]);
		}
		
		//시작시간이 빠른순부터...
		Arrays.sort(studyplans, (study1, study2) -> study1.start - study2.start);

		Stack<Plan> stop = new Stack<>(); //하다가 멈춘 과제
		
		List<String> answer = new ArrayList<>(); //출력할 정답
		
		for (int i = 0; i < studyplans.length - 1; i++) {
			
			Plan curPlan = studyplans[i]; //지금해야하는 과제
			Plan nextPlan = studyplans[i + 1]; //그 다음 과제

			//지금과제가 끝나는 시간이 다음 과제 시작시작보다 뒤에라면!
			if (curPlan.endTime() > nextPlan.start) {
				//그 사이 간격만큼을 빼서 넣어놔 넣어놔
				curPlan.playTime = curPlan.endTime() - nextPlan.start;
				stop.push(curPlan);
				continue;
			}
			
			//만약에 끝났다면 정답에 넣어줘
			answer.add(curPlan.name);
			
			//다음계획 시작전까지 남은 시간
			int restTime = nextPlan.start - curPlan.endTime();
			
			//남은시간이 있는데, stop한 과제들이 남아있다면 실행해줘 = 빈 시간에 멈췄던 과제 다시 진행
			while (restTime > 0 && !stop.isEmpty()) {
				Plan restart = stop.peek(); //하나씩 꺼내서 다시 시작
				
				//지금 남아있는 빈 시간을 playTime에서 빼줘야 공부하는 순공시간
				int studyTime = restart.playTime - restTime;
				
				if (studyTime > 0) {
			        // 아직 과제를 다 끝내지 못한 경우
			        restart.playTime = studyTime; // 남은 과제 시간 업데이트
			        break; // 루프 탈출
			    } else {
			        // 과제를 모두 완료한 경우 (studyTime <= 0)
			        restTime = -studyTime; // 남은 시간을 양수로 변환하여 업데이트
			        answer.add(stop.pop().name); // 과제 완료, 스택에서 제거
			    }
			}
		} //가장 마지막 nextPlan을 놔두고 끝남
		
		answer.add(studyplans[studyplans.length - 1].name); // 마지막 index의 plan 처리
		
		//만약에 하던 과제가 다시 있으면 
		while (!stop.isEmpty())  {
			answer.add(stop.pop().name); // stack에 남아있던 plan들 넣기
		}
		
		return answer.toArray(new String[answer.size()]); //마지막은 String[]로 변환해주는 메서드
	}
}