function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;

  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  const queue = [[0, 0, 1]]; // [x, y, distance]
  maps[0][0] = 0; // 방문 체크

  while (queue.length > 0) {
    const [x, y, distance] = queue.shift();

    if (x === n - 1 && y === m - 1) {
      return distance;
    }

    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] === 1) {
        queue.push([nx, ny, distance + 1]);
        maps[nx][ny] = 0; // 방문 체크
      }
    }
  }

  return -1; // 도착점에 도달할 수 없는 경우: -1 반환
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.21ms, 33.5MB)
// 테스트 2 〉	통과 (0.20ms, 33.4MB)
// 테스트 3 〉	통과 (0.24ms, 33.4MB)
// 테스트 4 〉	통과 (0.33ms, 33.5MB)
// 테스트 5 〉	통과 (0.20ms, 33.4MB)
// 테스트 6 〉	통과 (0.22ms, 33.5MB)
// 테스트 7 〉	통과 (0.22ms, 33.6MB)
// 테스트 8 〉	통과 (0.21ms, 33.6MB)
// 테스트 9 〉	통과 (0.23ms, 33.4MB)
// 테스트 10 〉	통과 (0.22ms, 33.4MB)
// 테스트 11 〉	통과 (0.20ms, 33.4MB)
// 테스트 12 〉	통과 (0.20ms, 33.5MB)
// 테스트 13 〉	통과 (0.20ms, 33.5MB)
// 테스트 14 〉	통과 (0.23ms, 33.5MB)
// 테스트 15 〉	통과 (0.20ms, 33.5MB)
// 테스트 16 〉	통과 (0.10ms, 33.4MB)
// 테스트 17 〉	통과 (0.21ms, 33.5MB)
// 테스트 18 〉	통과 (0.08ms, 33.5MB)
// 테스트 19 〉	통과 (0.09ms, 33.4MB)
// 테스트 20 〉	통과 (0.08ms, 33.5MB)
// 테스트 21 〉	통과 (0.08ms, 33.4MB)
// 효율성  테스트
// 테스트 1 〉	통과 (33.53ms, 38MB)
// 테스트 2 〉	통과 (28.92ms, 37.6MB)
// 테스트 3 〉	통과 (7.71ms, 38.1MB)
// 테스트 4 〉	통과 (6.86ms, 38MB)
