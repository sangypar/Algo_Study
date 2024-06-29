import java.util.*;

public class BJ15686_치킨배달 {
    
    static int[][] city;
    static List<int[]> houseList;
    static List<int[]> chickenList;
    static int answer;
    static int n, m;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        city = new int[n][n];
        
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                int input = sc.nextInt();
                city[r][c] = input;
                
                if(input == 1) houseList.add(new int[] {r, c});
                else if(input == 2) chickenList.add(new int[] {r, c});
            }
        }
        
        answer = Integer.MAX_VALUE;
        
        // 비트마스킹을 이용하여 치킨집 선택
        for(int i = 0; i < (1 << chickenList.size()); i++) {
            if(Integer.bitCount(i) == m) { // m개의 치킨집을 선택한 경우에 대해서만 계산
                search(i);
            }
        }
        
        System.out.println(answer);
    }
    
    private static void search(int bitmask) {
        int distSum = 0;
        
        for(int i = 0; i < houseList.size(); i++) {
            int houseR = houseList.get(i)[0];
            int houseC = houseList.get(i)[1];
            
            int minDist = Integer.MAX_VALUE;
            
            for(int j = 0; j < chickenList.size(); j++) {
                if((bitmask & (1 << j)) != 0) { // j번째 치킨집이 선택된 경우
                    int chickenR = chickenList.get(j)[0];
                    int chickenC = chickenList.get(j)[1];
                    
                    // Calculate Manhattan distance
                    int dist = Math.abs(houseR - chickenR) + Math.abs(houseC - chickenC);
                    
                    // Update minimum distance
                    minDist = Math.min(minDist, dist);
                }
            }
            
            // Add the minimum distance to the total distance sum
            distSum += minDist;
        }
        
        // Update the answer with the minimum distance sum found
        answer = Math.min(answer, distSum);
    }
}
