// readline 모듈 import
const readline = require("readline");

// 입출력을 위한 인터페이스 객체 생성
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const lines = [];

rl.on('line', (line) => {
  lines.push(line);
});

rl.on('close', () => {
  // console.log(lines);
  [N, M] = lines[0].split(' ').map(Number);
  const limits = lines[1].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  let ans = 0;

  for (let i = 2; i < M + 2; i++) {
    const [a, b] = lines[i].split(' ').map(Number);
    adjList[a].push(b);
    adjList[b].push(a);
  }
  // console.log(arr);

  for (let i = 1; i <= N; i++) {
    let flag = true;  // 자신이 최고라고 생각하는지
    for (let j of adjList[i]) {
      if (limits[i - 1] <= limits[j - 1]) {
        flag = false;
        break;
      }
    }
    if (flag) {
      ans++;
    }
  }

  console.log(ans);
});