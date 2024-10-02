import java.util.*;

class Solution {

    Set<Set<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        findAbuser(new HashSet<>(), 0, user_id, banned_id);
        return answer.size();
    }

    private void findAbuser (Set<String> set, int idx, String[] user_id, String[] banned_id) {
        if (idx == banned_id.length) {
            answer.add(new HashSet<>(set));
            return;
        }

        String ban = banned_id[idx];

        for (String u : user_id) {
            if (set.contains(u)) continue;

            if (isAbuser(u, ban)) {
                set.add(u);
                findAbuser(set, idx + 1, user_id, banned_id);
                set.remove(u);
            }
        }
    }

    private boolean isAbuser (String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
//테스트 1 〉	통과 (0.08ms, 75.9MB)
//테스트 2 〉	통과 (0.24ms, 77.4MB)
//테스트 3 〉	통과 (0.26ms, 73MB)
//테스트 4 〉	통과 (0.15ms, 72.3MB)
//테스트 5 〉	통과 (64.56ms, 125MB)
//테스트 6 〉	통과 (2.91ms, 75.4MB)
//테스트 7 〉	통과 (0.14ms, 79MB)
//테스트 8 〉	통과 (0.12ms, 75.3MB)
//테스트 9 〉	통과 (0.15ms, 76.3MB)
//테스트 10 〉	통과 (0.08ms, 72.1MB)
//테스트 11 〉	통과 (0.27ms, 78.2MB)