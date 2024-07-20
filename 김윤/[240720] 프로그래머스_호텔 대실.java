import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time_array = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            
            if (end % 100 >= 60) end += 40;
            
            time_array[i][0] = start;
            time_array[i][1] = end;
        }
        
        Arrays.sort(time_array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });
        
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < time_array.length; i++) {
            Collections.sort(rooms);
            boolean isAdd = false;
            
            for (int j = 0; j < rooms.size(); j++) {
                if (time_array[i][0] >= rooms.get(j)) {
                    rooms.set(j, time_array[i][1]);
                    isAdd = true;
                    break;
                }
            }
            
            if (!isAdd) rooms.add(time_array[i][1]);
        }
        
    return rooms.size();
    }
}

// 테스트 1 〉	통과 (0.90ms, 86.5MB)
// 테스트 2 〉	통과 (3.78ms, 73.4MB)
// 테스트 3 〉	통과 (24.24ms, 85.1MB)
// 테스트 4 〉	통과 (8.57ms, 72.8MB)
// 테스트 5 〉	통과 (0.48ms, 66.9MB)
// 테스트 6 〉	통과 (16.12ms, 89MB)
// 테스트 7 〉	통과 (16.84ms, 81.8MB)
// 테스트 8 〉	통과 (6.53ms, 89.5MB)
// 테스트 9 〉	통과 (4.70ms, 82.5MB)
// 테스트 10 〉	통과 (9.47ms, 80.6MB)
// 테스트 11 〉	통과 (18.53ms, 85.3MB)
// 테스트 12 〉	통과 (13.72ms, 80.1MB)
// 테스트 13 〉	통과 (4.80ms, 83.7MB)
// 테스트 14 〉	통과 (18.41ms, 80.6MB)
// 테스트 15 〉	통과 (22.82ms, 78.4MB)
// 테스트 16 〉	통과 (7.36ms, 79.5MB)
// 테스트 17 〉	통과 (22.40ms, 80.4MB)
// 테스트 18 〉	통과 (11.87ms, 80.2MB)
// 테스트 19 〉	통과 (20.69ms, 92.8MB)
