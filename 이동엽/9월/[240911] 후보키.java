import java.util.*;

class Solution {

    int x, y, max;
    boolean[] visited;
    List<Integer> sel = new ArrayList<>();
    List<List<Integer>> candidates = new ArrayList<>();

    public int solution(String[][] relation) {

        x = relation.length;
        y = relation[0].length;
        visited = new boolean[y];

        for (int i = 0; i < y; i++) {
            max = i;
            combination(0, 0, relation);
        }

        return candidates.size();
    }

    void verify(String[][] relation) {
        Set<String> combs = new HashSet<>();

        for (int i = 0; i < y; i++) {
            StringBuilder sb = new StringBuilder();
            for (int s : sel) {
                sb.append(relation[i][s]);
            }
            combs.add(sb.toString());
        }
        // 유일성 check
        // 최소성 check
    }

    void combination(int idx, int cnt, int[][] relation) {
        if (cnt == max + 1) {
            sel = new ArrayList<>();
            for (int i = 0; i < y; i++) {
                if (visited[i]) {
                    sel.add(i);
                }
            }

        }
    }

}