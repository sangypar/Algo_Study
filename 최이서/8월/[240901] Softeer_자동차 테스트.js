const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on('line', function (line) {
  input.push(line);
}).on('close', function () {

  let [n, q] = input[0].split(" ").map(Number); // n개의 자동차, q개의 질의
  let arr = input[1].split(" ").map(Number);    // 연비 리스트
  
  arr.sort((a, b) => a - b);  // 연비 정렬
  
  for (let i = 0; i < q; i++) {
    let m = Number(input[2 + i]); // 질의 값
  
    let low = -1;
    let high = n - 1;
  
    while (low + 1 < high) {
      let mid = Math.floor((low + high) / 2);  // 중간 인덱스 계산
  
      // 질의 값보다 arr[mid]가 크거나 같으면 high 이동
      if (arr[mid] >= m) {
        high = mid;
      } else { // 질의 값보다 작으면 low 이동
        low = mid;
      }
    }
  
    // arr[high] = 질의 값의 등장 인덱스
    if (arr[high] !== m) {
      console.log(0); // 배열에 없는 경우
    } else {
      // 질의 값보다 작은 연비 값의 개수 * 큰 연비 값의 개수
      console.log(high * (n - 1 - high));
    }
  }
});