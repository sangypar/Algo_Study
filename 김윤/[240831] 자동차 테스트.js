const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let output = [];

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  const [n, q] = input[0].split(" ").map(Number); // 자동차 개수와 질의 개수
  const cars = input[1].split(" ").map(Number); // 자동차 연비 배열
  const queries = input.slice(2).map(Number); // 질의 배열

  cars.sort((a, b) => a - b);

  // 이진 탐색 함수: 특정 값 이상이 처음 나오는 위치를 찾음
  function lowerBound(arr, target) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
      let mid = Math.floor((left + right) / 2);
      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  // 이진 탐색 함수: 특정 값보다 큰 값이 처음 나오는 위치를 찾음
  function upperBound(arr, target) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
      let mid = Math.floor((left + right) / 2);
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  queries.forEach((mid) => {
    const lower = lowerBound(cars, mid);
    const upper = upperBound(cars, mid);

    if (lower < n && cars[lower] === mid) {
      const smallerCount = lower;
      const largerCount = n - upper;
      output.push(smallerCount * largerCount);
    } else {
      output.push(0);
    }
  });

  output.forEach((value) => console.log(value));
});
