// 메모리 초과

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
  const arr = [];
  let ans = 0;

  for (let i = 0; i <= N; i++) {
    arr.push([]);
    for (let j = 0; j <= N; j++) {
      arr[i].push(0);
    }
  }

  for (let i = 2; i < M + 2; i++) {
    [a, b] = lines[i].split(' ').map(Number);
    arr[a][b] = 1;
    arr[b][a] = 1;
  }

  // console.log(arr);

  for (let i = 1; i <= N; i++) {
    let flag = true;  // 자신이 최고라고 생각하는지
    for (let j = 1; j <= N; j++) {
      if (j === i || arr[i][j] === 0)
        continue;

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

// Subtask 1
// NO	이름	결과	실행시간	메모리
// 1	1	
// 메모리초과
// 0.684 초	256.00 MB
// 2	10	
// 메모리초과
// 0.647 초	256.00 MB
// 3	11	
// 메모리초과
// 0.657 초	256.00 MB
// 4	12	정답
// 0.039 초	8.52 MB
// 5	13	정답
// 0.039 초	8.54 MB
// 6	14	정답
// 0.039 초	8.54 MB
// 7	15	정답
// 0.039 초	8.53 MB
// 8	16	정답
// 0.039 초	8.65 MB
// 9	17	
// 메모리초과
// 0.659 초	256.00 MB
// 10	18	
// 메모리초과
// 0.670 초	256.00 MB
// 11	19	
// 메모리초과
// 0.658 초	256.00 MB
// 12	2	
// 메모리초과
// 0.658 초	256.00 MB
// 13	3	
// 메모리초과
// 0.652 초	256.00 MB
// 14	4	정답
// 0.039 초	8.56 MB
// 15	5	정답
// 0.039 초	8.53 MB
// 16	6	
// 메모리초과
// 0.660 초	256.00 MB
// 17	7	
// 메모리초과
// 0.654 초	256.00 MB
// 18	8	
// 메모리초과
// 0.652 초	256.00 MB
// 19	9	
// 메모리초과
// 0.643 초	256.00 MB