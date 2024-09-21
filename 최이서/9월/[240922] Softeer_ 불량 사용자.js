function solution(user_id, banned_id) {
  const result = new Set();

  function checkMatch(user_id, id) {
    if (user_id.length !== id.length) return false;

    for (let i = 0; i < user_id.length; i++) {
      if (id[i] !== "*" && id[i] !== user_id[i]) return false;
    }
    return true;
  }

  function dfs(depth, selected) {
    if (depth === banned_id.length) {
      result.add([...selected].sort().join(","));
      return;
    }

    for (let i = 0; i < user_id.length; i++) {
      if (
        !selected.has(user_id[i]) &&
        checkMatch(user_id[i], banned_id[depth])
      ) {
        selected.add(user_id[i]);
        dfs(depth + 1, selected);
        selected.delete(user_id[i]);
      }
    }
  }

  dfs(0, new Set());
  return result.size;
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.09ms, 33.5MB)
// 테스트 2 〉	통과 (0.22ms, 33MB)
// 테스트 3 〉	통과 (0.23ms, 33.5MB)
// 테스트 4 〉	통과 (0.22ms, 33.5MB)
// 테스트 5 〉	통과 (91.47ms, 37.9MB)
// 테스트 6 〉	통과 (17.05ms, 37MB)
// 테스트 7 〉	통과 (0.21ms, 33.5MB)
// 테스트 8 〉	통과 (0.23ms, 33.4MB)
// 테스트 9 〉	통과 (0.24ms, 33.4MB)
// 테스트 10 〉	통과 (0.19ms, 33.4MB)
// 테스트 11 〉	통과 (0.25ms, 33.5MB)
