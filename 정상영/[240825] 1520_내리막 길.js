const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function solution(arr) {
    const [m, n] = arr[0].split(' ').map(Number);

    const map = [];
    const dp = Array.from(Array(m), () => Array(n).fill(-1)); // dp 배열 초기화

    for (let i = 0; i < m; i++) {
        map.push(arr[i + 1].split(' ').map(Number));
    }

    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];

    const dfs = (r, c) => {
        if (r === m - 1 && c === n - 1) return 1; // 목적지에 도달하면 경로 1개 추가

        if (dp[r][c] !== -1) return dp[r][c]; // 이미 계산된 경로가 있으면 해당 값을 반환

        dp[r][c] = 0; // 경로 계산 시작
        for (let i = 0; i < 4; i++) {
            const nr = r + dr[i];
            const nc = c + dc[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc); // 현재 위치에서 갈 수 있는 경로를 모두 탐색
            }
        }

        return dp[r][c];
    };

    return dfs(0, 0); // 시작점에서 dfs 시작
}

console.log(solution(input));
