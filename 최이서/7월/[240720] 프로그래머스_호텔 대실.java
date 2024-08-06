import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(String[][] book_time) {
        int ans = 0;
    	
    	ArrayList<int[]> rooms = new ArrayList<>();
    	int[][] bookInfo = new int[book_time.length][2];
    	
    	for(int i=0; i<book_time.length; i++){
    		bookInfo[i][0] = toMinutes(book_time[i][0]);
    		bookInfo[i][1] = toMinutes(book_time[i][1]) + 10;
        }
    	
    	
    	// 시간 순 정렬
    	Arrays.sort(bookInfo, new Comparator<int[]>() {
    		@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
    	
    	// 인덱스 0 add
    	rooms.add(bookInfo[0]);
    	
    	// 0제외 1부터 시작
    	for (int i = 1; i < bookInfo.length; i++) {
            
    		int nextBook = bookInfo[i][0];
            
            for (int j = 0; j < rooms.size(); j++) {
            	if (nextBook >= rooms.get(j)[1]) {
            		rooms.remove(j);
            		break;
            	}
            }
            
            rooms.add(bookInfo[i]);
    	}
    	
    	ans = rooms.size();
        return ans;
    }
    
    private static int toMinutes(String time) {
    	String[] parts = time.split(":");
    	return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.52ms, 72MB)
// 테스트 2 〉	통과 (2.53ms, 75MB)
// 테스트 3 〉	통과 (10.41ms, 91.8MB)
// 테스트 4 〉	통과 (6.76ms, 81.1MB)
// 테스트 5 〉	통과 (0.59ms, 83.4MB)
// 테스트 6 〉	통과 (8.85ms, 76.4MB)
// 테스트 7 〉	통과 (9.47ms, 77.2MB)
// 테스트 8 〉	통과 (3.97ms, 92.4MB)
// 테스트 9 〉	통과 (3.22ms, 75.2MB)
// 테스트 10 〉통과 (10.42ms, 83MB)
// 테스트 11 〉통과 (12.43ms, 81MB)
// 테스트 12 〉통과 (14.68ms, 83.6MB)
// 테스트 13 〉통과 (2.35ms, 84.1MB)
// 테스트 14 〉통과 (10.02ms, 85.1MB)
// 테스트 15 〉통과 (14.18ms, 80.2MB)
// 테스트 16 〉통과 (5.85ms, 84.5MB)
// 테스트 17 〉통과 (11.94ms, 73.3MB)
// 테스트 18 〉통과 (7.83ms, 77.4MB)
// 테스트 19 〉통과 (17.75ms, 85.8MB) {
  

