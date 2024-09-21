function solution(jobs) {
  let answer = 0;
  let Q = [];

  // 시점 기준 정렬
  jobs.sort((a, b) => {
    return a[0] - b[0];
  });

  let len = jobs.length;
  let i = 0; // 현재 처리하는 작업
  let time = 0; // 현재 시간(now)

  while (i < len || Q.length > 0) {
    // 현재 시간이 다음 작업의 요청 시간보다 크거나 같다면 큐에 추가
    if (i < len && jobs[i][0] <= time) {
      Q.push(jobs[i++]);
      continue;
    }

    // 처리 시간 기준 정렬
    Q.sort((a, b) => {
      return a[1] - b[1];
    });

    if (Q.length > 0) {
      let job = Q.shift();
      time += job[1];
      answer += time - job[0];
    } else {
      time = jobs[i][0];
    }
  }
  answer = Math.floor(answer / len);
  return answer;
}

// 정확성  테스트
// 테스트 1 〉	통과 (4.31ms, 36.5MB)
// 테스트 2 〉	통과 (3.69ms, 36.3MB)
// 테스트 3 〉	통과 (3.25ms, 36MB)
// 테스트 4 〉	통과 (3.15ms, 36MB)
// 테스트 5 〉	통과 (4.15ms, 36.5MB)
// 테스트 6 〉	통과 (0.19ms, 33.4MB)
// 테스트 7 〉	통과 (3.22ms, 35.9MB)
// 테스트 8 〉	통과 (2.23ms, 35.7MB)
// 테스트 9 〉	통과 (0.54ms, 33.5MB)
// 테스트 10 〉	통과 (4.89ms, 36.5MB)
// 테스트 11 〉	통과 (0.16ms, 33.5MB)
// 테스트 12 〉	통과 (0.17ms, 33.5MB)
// 테스트 13 〉	통과 (0.17ms, 33.4MB)
// 테스트 14 〉	통과 (0.09ms, 33.4MB)
// 테스트 15 〉	통과 (0.09ms, 33.4MB)
// 테스트 16 〉	통과 (0.08ms, 33.5MB)
// 테스트 17 〉	통과 (0.08ms, 33.4MB)
// 테스트 18 〉	통과 (0.10ms, 33.5MB)
// 테스트 19 〉	통과 (0.08ms, 33.4MB)
// 테스트 20 〉	통과 (0.06ms, 33.4MB)
