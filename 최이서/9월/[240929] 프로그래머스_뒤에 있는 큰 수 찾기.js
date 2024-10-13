function solution(numbers) {
  const length = numbers.length;
  const result = new Array(length).fill(-1);
  const indexStack = [];

  for (let i = 0; i < length; i++) {
    const curNum = numbers[i];

    while (indexStack.length > 0) {
      const topIdx = indexStack[indexStack.length - 1];
      const topNum = numbers[topIdx];

      if (topNum >= curNum) {
        break;
      }

      indexStack.pop();
      result[topIdx] = curNum;
    }

    indexStack.push(i);
  }

  return result;
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.07ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.15ms, 33.5MB)
// 테스트 4 〉	통과 (0.17ms, 33.4MB)
// 테스트 5 〉	통과 (0.28ms, 33.6MB)
// 테스트 6 〉	통과 (2.79ms, 38.2MB)
// 테스트 7 〉	통과 (4.53ms, 38.1MB)
// 테스트 8 〉	통과 (3.78ms, 42.6MB)
// 테스트 9 〉	통과 (3.81ms, 42.5MB)
// 테스트 10 〉	통과 (4.99ms, 45MB)
// 테스트 11 〉	통과 (5.47ms, 44.8MB)
// 테스트 12 〉	통과 (7.15ms, 52.1MB)
// 테스트 13 〉	통과 (11.03ms, 51.9MB)
// 테스트 14 〉	통과 (14.42ms, 79.1MB)
// 테스트 15 〉	통과 (26.98ms, 126MB)
// 테스트 16 〉	통과 (38.58ms, 126MB)
// 테스트 17 〉	통과 (26.90ms, 126MB)
// 테스트 18 〉	통과 (31.90ms, 126MB)
// 테스트 19 〉	통과 (27.52ms, 135MB)
// 테스트 20 〉	통과 (51.76ms, 159MB)
// 테스트 21 〉	통과 (44.82ms, 152MB)
// 테스트 22 〉	통과 (26.66ms, 108MB)
// 테스트 23 〉	통과 (55.72ms, 149MB)
