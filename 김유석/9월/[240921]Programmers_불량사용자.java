import java.util.HashSet;

/**
 * 1. depth와 
 */


class Solution {

    // 사용자 아이디와 불량 사용자 아이디 배열, 방문 여부를 저장할 visited 배열
    String[] userIds;
    String[] bannedIds;
    boolean[] visited;

    // 최종 결과를 담을 HashSet, 중복된 조합을 방지하기 위해 HashSet 사용
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        // 초기화: 주어진 사용자와 불량 사용자 ID 배열을 멤버 변수에 할당 : 다른 메서드에서도 쓸수있게하기위함
        userIds = user_id;
        bannedIds = banned_id;

        // 각 사용자가 선택되었는지를 나타내는 방문 배열
        visited = new boolean[userIds.length];

        // DFS를 사용하여 가능한 조합을 탐색
        dfs(new HashSet<>(), 0);

        // 최종 결과 조합의 크기를 반환
        return result.size();
    }

    // DFS (깊이 우선 탐색) 메서드, 불량 사용자 목록과 일치하는 사용자의 조합을 찾음
    void dfs(HashSet<String> set, int depth) {
        // 만약 현재 깊이가 불량 사용자 ID의 개수와 같다면
        // 즉, 모든 불량 사용자에 대해 일치하는 사용자를 찾았다면
        if (depth == bannedIds.length) {
            result.add(set);  // 현재 조합을 결과에 추가
            return;  // 재귀 종료
        }

        // 모든 사용자 ID를 순회하면서 현재 depth의 불량 사용자와 매칭 가능한지 확인
        for (int i = 0; i < userIds.length; i++) {
            // 이미 선택된 사용자면 건너뜀
            if (set.contains(userIds[i])) {
                continue;
            }

            // 현재 사용자와 불량 사용자가 매칭되는지 확인
            if (check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);  // 매칭되는 사용자라면 현재 조합에 추가
                dfs(new HashSet<>(set), depth + 1);  // 다음 불량 사용자로 재귀 호출
                set.remove(userIds[i]);  // 재귀가 끝난 후 사용자를 조합에서 제거하여 백트래킹
            }
        }
    }

    // 현재 사용자가 불량 사용자 조건과 일치하는지 체크하는 메서드
    boolean check(String userId, String bannedId) {
        // 사용자 ID와 불량 사용자 ID의 길이가 다르면 매칭 불가
        if (userId.length() != bannedId.length()) {
            return false;
        }

        // 각 문자별로 불량 사용자 ID와 일치하는지 확인
        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            // 불량 사용자 ID가 '*'이 아닌데 일치하지 않으면 매칭 실패
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }

        // 모든 문자가 일치하면 true 반환, 그렇지 않으면 false
        return match;
    }
}
