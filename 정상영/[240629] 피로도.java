class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, 0, k);
        
        return answer;
    }
    
    static void dfs(int[][] dungeons, int cnt, int stamina) {
        for(int i = 0; i < dungeons.length; i++) {
            
            if(!visited[i] && stamina >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, cnt + 1, stamina - dungeons[i][1]);
                visited[i] = false;
            }
        }
        
        answer = Math.max(cnt, answer);
    }
}