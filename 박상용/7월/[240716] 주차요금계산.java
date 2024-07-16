import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	static class Car implements Comparable<Car> {
		int intime; // IN 시간
		boolean flag; // 주차장에 있으면 true, 없으면 false
		int carnum; // 차번호
		int count; // 총 주차 시간

		public Car(int intime, boolean flag, int carnum, int count) {
			this.intime = intime;
			this.flag = flag;
			this.carnum = carnum;
			this.count = count;
		}

		@Override
		public int compareTo(Car o) { // 차량 번호 순 정렬
			return this.carnum - o.carnum;
		}

	}

	public List<Integer> solution(int[] fees, String[] records) {
		int ktime = fees[0]; // 기본 시간
		int kcost = fees[1]; // 기본 요금
		int dtime = fees[2]; // 단위 시간
		int dcost = fees[3]; // 단위 요금

		List<Car> list = new ArrayList<>(); // 차량 담을 배열

		for (int i = 0; i < records.length; i++) {
			int hour = Integer.parseInt(records[i].substring(0, 2)); // 시간
			int min = Integer.parseInt(records[i].substring(3, 5)); // 분
			int time = hour * 60 + min; 
			int carnum = Integer.parseInt(records[i].substring(6, 10)); 
			boolean find = false; // 들어온적이 있는 차인지 확인

			if (records[i].charAt(11) == 'I') { // IN일 경우
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).carnum == carnum) { // 한번 이상 온 차량인지
						list.get(j).intime = time;
						list.get(j).flag = true;
						find = true;
						break;
					}
				}
				if (!find) // 처음 온 차량이면 list 추가
					list.add(new Car(time, true, carnum, 0));
			} else { // OUT일 경우
				for (int j = 0; j < list.size(); j++) { 
					if (list.get(j).carnum == carnum) {
						list.get(j).count += time - list.get(j).intime;
						list.get(j).flag = false;
						break;
					}
				}
			}
		}
		for (int j = 0; j < list.size(); j++) { // 주차장에 있는 차량이면 23:59분에 내보내기
			if (list.get(j).flag) {
				list.get(j).count += 1439 - list.get(j).intime;
				list.get(j).flag = false;
			}
		}

		Collections.sort(list); // 정렬
		List<Integer> answer = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) { // 요금계산
			int cost = kcost;
			if (list.get(j).count > ktime) {
				cost += (int) Math.ceil((double) (list.get(j).count - ktime) / dtime) * dcost;
			}
			answer.add(cost);
		}
		return answer;
	}
}