class Solution {
    
  static boolean[] visited;
  static int ans = Integer.MIN_VALUE;
  
  public int solution(int k, int[][] dungeons) {

      visited = new boolean[dungeons.length];
      int cnt = 0;
      DFS(k, dungeons, cnt);
      
      return ans;
  }
  
  public static void DFS(int k, int[][] dungeons, int cnt) {
      for (int i = 0; i < dungeons.length; i++) {
          if (!visited[i] && dungeons[i][0] <= k) {
              visited[i] = true;
              DFS(k - dungeons[i][1], dungeons, cnt+1);
              visited[i] = false;
          }
      }
      ans = Math.max(ans, cnt);
  }
}