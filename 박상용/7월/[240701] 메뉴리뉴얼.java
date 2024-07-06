import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	static int limit;
	static int[] alphabet = new int[26];
	static List<String> answer = new ArrayList<>();
	static List<Node> tmp = new ArrayList<>();
	static int[][] arr;

	static class Node {
		int cnt;
		String str;

		public Node(int cnt, String str) {
			this.cnt = cnt;
			this.str = str;
		}

	}

	public List<String> solution(String[] orders, int[] course) {
		arr = new int[orders.length][26];

		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < orders[i].length(); j++) {
				arr[i][orders[i].charAt(j) - 'A']++;
			}
		}

		for (int i = 0; i < course.length; i++) {
			limit = course[i];
			comb(0, 0);
		}

		for (int i = 0; i < course.length; i++) {
			int max = 0;
			for (int j = 0; j < tmp.size(); j++) {
				if (course[i] == tmp.get(j).str.length()) {
					max = Math.max(max, tmp.get(j).cnt);
				}
			}
			for (int j = 0; j < tmp.size(); j++) {
				if (course[i] == tmp.get(j).str.length() && max == tmp.get(j).cnt) {
					answer.add(tmp.get(j).str);
				}
			}
		}
		Collections.sort(answer);
		return answer;
	}	

	private void comb(int idx, int cnt) {
		if (cnt >= limit) {
			check();
			return;
		}
		if (idx > 25)
			return;

		alphabet[idx]++;
		comb(idx + 1, cnt + 1);
		alphabet[idx]--;
		comb(idx + 1, cnt);
	}

	private void check() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int cnt2 = 0;
			for (int j = 0; j < 26; j++) {
				if (alphabet[j] == 1 && arr[i][j] == 1)
					cnt2++;
			}
			if (cnt2 == limit)
				cnt++;
		}
		if (cnt >= 2) {
			String str = new String();
			for (int k = 0; k < 26; k++) {
				if (alphabet[k] == 1) {
					str += (char) ('A' + k);
				}
			}
			tmp.add(new Node(cnt, str));
		}
	}
}