import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	boolean[] visited;
	int col, row, limit;
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> list2 = new ArrayList<>();

	public int solution(String[][] relation) {
		int answer = 0;

		col = relation[0].length;
		row = relation.length;
		visited = new boolean[col];

		for (int i = 0; i < col; i++) {
			limit = i;
			comb(0, 0, relation);
		}
		return list2.size();
	}

	public void comb(int idx, int cnt, String[][] relation) {
		if (cnt == limit + 1) {
			list = new ArrayList<>();
			for (int i = 0; i < col; i++) {
				if (visited[i]) {
					list.add(i);
				}
			}
			check(relation);
			return;
		}

		if (idx == col) {
			return;
		}

		visited[idx] = true;
		comb(idx + 1, cnt + 1, relation);
		visited[idx] = false;
		comb(idx + 1, cnt, relation);
	}

	public void check(String[][] relation) {

		Set<String> set = new HashSet<>();
		for (int i = 0; i < row; i++) {
			String tmp = "";
			for (int j = 0; j < list.size(); j++) {
				tmp += relation[i][list.get(j)];
			}
			set.add(tmp);
		}

		if (set.size() == row) {
			boolean flag = false;
			
			for(int i = 0; i < list2.size(); i++) {
				if(list.containsAll(list2.get(i))) {
					flag = true;
			        break;
				}
			}
			
			if (!flag) {
				List<Integer> list3 = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					list3.add(list.get(i));
				}
				list2.add(list3);
			}
		}

	}
}

//테스트 1 〉	통과 (1.46ms, 76.1MB)
//테스트 2 〉	통과 (1.56ms, 70.5MB)
//테스트 3 〉	통과 (1.63ms, 69.9MB)
//테스트 4 〉	통과 (1.45ms, 69.1MB)
//테스트 5 〉	통과 (2.63ms, 73.4MB)
//테스트 6 〉	통과 (2.02ms, 72.3MB)
//테스트 7 〉	통과 (1.80ms, 77.7MB)
//테스트 8 〉	통과 (1.73ms, 72.4MB)
//테스트 9 〉	통과 (2.00ms, 67.6MB)
//테스트 10 〉	통과 (1.73ms, 84.2MB)
//테스트 11 〉	통과 (2.03ms, 67.6MB)
//테스트 12 〉	통과 (4.92ms, 75.6MB)
//테스트 13 〉	통과 (2.39ms, 75MB)
//테스트 14 〉	통과 (1.36ms, 75.9MB)
//테스트 15 〉	통과 (1.61ms, 71.7MB)
//테스트 16 〉	통과 (1.85ms, 74.1MB)
//테스트 17 〉	통과 (2.08ms, 71.8MB)
//테스트 18 〉	통과 (8.66ms, 76.8MB)
//테스트 19 〉	통과 (7.45ms, 78.3MB)
//테스트 20 〉	통과 (8.11ms, 75.8MB)
//테스트 21 〉	통과 (7.17ms, 77.7MB)
//테스트 22 〉	통과 (11.10ms, 71.7MB)
//테스트 23 〉	통과 (1.47ms, 71.7MB)
//테스트 24 〉	통과 (6.89ms, 80.4MB)
//테스트 25 〉	통과 (8.07ms, 79.9MB)
//테스트 26 〉	통과 (6.16ms, 74MB)
//테스트 27 〉	통과 (5.39ms, 73.2MB)
//테스트 28 〉	통과 (2.95ms, 73.9MB)