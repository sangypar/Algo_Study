import java.util.*;

public class Solution {
	
	static List<Integer> list = new ArrayList<>();      // 코스요리를 구성하는 메뉴 개수
	static boolean[] selected;                          // 코스 선택 여부 확인 배열
	static Map<String, Integer> M = new HashMap<>();    // 메뉴조합 비교 맵
	
    // orders: 손님들이 주문한 단품메뉴
    // course: 코스요리를 구성하는 단품 메뉴들의 개수
	public static List<String> solution(String[] orders, int[] course) {
        
        // 각 단품메뉴 = 미정렬 상태 >> 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
			char[] charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			orders[i] = String.valueOf(charArr);
		}
        
		for (int num : course) {
			list.add(num);
		}
		
		List<String> answer = new ArrayList<>();
		List<List<String>> crs = new ArrayList<>();
        
		int[] max = new int[11];			// 가장 많이 주문된 단품메뉴 개수 저장 배열
                                            // 단품 메뉴 개수: 2 이상 10 이하 자연수
        
        // 리스트 초기화
		for (int i = 0; i < 11; i++) {
        	crs.add(new ArrayList<>());
        }
		
        // 손님들이 주문한 단품메뉴 별 조합 추출
        for (String order : orders) {
        	selected = new boolean[order.length()];
        	comb(0, 0, order, selected);
        }
        
        // 각 entry를 순회하면서
        for (Map.Entry<String, Integer> entry : M.entrySet()) {

        	String key = entry.getKey();
        	int val = entry.getValue();
        	int len = key.length();
        	
            // 동일한 key(조합)길이 중 가장 큰 val(사용된 빈도수)값 구하기
        	if (max[len] < val) {
        		max[len] = val;
        	}
        }
        
        for (Map.Entry<String, Integer> entry : M.entrySet()) {
        	String key = entry.getKey();
        	int val = entry.getValue();
        	int len = key.length();
        	
            // 최대 val 값과 동일하고 최소 2명 이상의 손님으로부터 주문된 메뉴라면
        	if (max[len] == val && val >= 2) {
                // 정답 리스트에 추가
        		crs.get(len).add(key);
        	}
        }
        
        for (List<String> courses : crs) {
        	for (String c : courses) {
        		answer.add(c);
        	}
        }
        
        Collections.sort(answer);
        return answer;
    }

	private static void comb(int depth, int idx, String order, boolean[] selected) {
		
		if (depth == order.length()) {
			String str = "";
			
            // 메뉴 조합
			for (int i = 0; i < selected.length; i++) {
				if (selected[i] == true) {
					str += order.charAt(i);
				}
			}
			
			if (str == "")
				return;
			
            // 맵에 이미 저장되어있는 조합인 경우
			if (M.containsKey(str)) {
                // value + 1
				M.put(str, M.get(str) + 1);
			} else {
                // 저장되어있지 않은 경우 새로 추가
				if (list.contains(str.length())) {
					M.put(str, 1);
				}
			}
			return;
		}
		
		selected[idx] = true;
		comb(depth+1, idx+1, order, selected);
		selected[idx] = false;
		comb(depth+1, idx+1, order, selected);
	}
}