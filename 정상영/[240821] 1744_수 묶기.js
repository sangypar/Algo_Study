const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const input = fs.readFileSync('test.txt').toString().trim().split('\n').map(line => line.trim());

// 풀이
function solution(arr) {
    const n = parseInt(arr[0]);
    const numbers = arr.slice(1).map(Number);

    // 양수와 음수를 각각 저장할 배열
    const positiveNumbers = [];
    const negativeNumbers = [];

    // 주어진 숫자들을 양수, 음수, 그리고 1로 분류
    let answer = 0;
    for (let num of numbers) {
        if (num > 1) {
            positiveNumbers.push(num);
        } else if (num === 1) {
            // 1은 더하는 것이 곱하는 것보다 항상 크므로 바로 더하기
            answer += 1;
        } else if (num <= 0) {
            negativeNumbers.push(num);
        }
    }

    // 양수는 큰 수끼리 곱해야 최대값이 나오므로 내림차순 정렬
    positiveNumbers.sort((a, b) => b - a);
    // 음수는 작은 수끼리 곱해야 최대값이 나오므로 오름차순 정렬
    negativeNumbers.sort((a, b) => a - b);

    // 양수들을 최대한 묶어서 곱해 더하기
    for (let i = 0; i < positiveNumbers.length; i += 2) {
        if (i + 1 < positiveNumbers.length) {
            answer += positiveNumbers[i] * positiveNumbers[i + 1];
        } else {
            // 홀수개 남으면 그냥 더함
            answer += positiveNumbers[i];
        }
    }

    // 음수들을 최대한 묶어서 곱해 더하기
    for (let i = 0; i < negativeNumbers.length; i += 2) {
        if (i + 1 < negativeNumbers.length) {
            answer += negativeNumbers[i] * negativeNumbers[i + 1];
        } else {
            // 홀수개 남으면 그냥 더함 (단, 이 경우 음수 하나만 남으면 처리)
            answer += negativeNumbers[i];
        }
    }

    return answer;
}

console.log(solution(input));