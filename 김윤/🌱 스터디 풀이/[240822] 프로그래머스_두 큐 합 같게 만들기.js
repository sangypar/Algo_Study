function solution(queue1, queue2) {
    const total = queue1.concat(queue2);
    let sum1 = queue1.reduce((a, b) => a + b, 0);
    let sum2 = queue2.reduce((a, b) => a + b, 0);
    const target = (sum1 + sum2) / 2;
    
    if ((sum1 + sum2) % 2 === 1) return -1;
    
    let left = 0;
    let right = queue1.length;
    let count = 0;
    
    while (left <= right && right < total.length) {
        if (sum1 === target) return count;

        if (sum1 > target) {
            sum1 -= total[left];
            left++;
        } else {
            sum1 += total[right];
            right++;
        }
        count++;
    }
    
    return -1;
}

// 테스트 1 〉	통과 (0.07ms, 33.6MB)
// 테스트 2 〉	통과 (0.07ms, 33.6MB)
// 테스트 3 〉	통과 (0.08ms, 33.5MB)
// 테스트 4 〉	통과 (0.11ms, 33.6MB)
// 테스트 5 〉	통과 (0.17ms, 33.5MB)
// 테스트 6 〉	통과 (0.17ms, 33.6MB)
// 테스트 7 〉	통과 (0.16ms, 33.6MB)
// 테스트 8 〉	통과 (0.10ms, 33.6MB)
// 테스트 9 〉	통과 (0.22ms, 33.6MB)
// 테스트 10 〉	통과 (0.28ms, 33.6MB)
// 테스트 11 〉	통과 (5.89ms, 37.7MB)
// 테스트 12 〉	통과 (5.63ms, 37.7MB)
// 테스트 13 〉	통과 (3.91ms, 39.6MB)
// 테스트 14 〉	통과 (4.59ms, 40.1MB)
// 테스트 15 〉	통과 (6.14ms, 41.3MB)
// 테스트 16 〉	통과 (4.62ms, 41.3MB)
// 테스트 17 〉	통과 (4.96ms, 39.8MB)
// 테스트 18 〉	통과 (12.17ms, 54.2MB)
// 테스트 19 〉	통과 (13.64ms, 55.3MB)
// 테스트 20 〉	통과 (18.21ms, 56.3MB)
// 테스트 21 〉	통과 (18.42ms, 56.4MB)
// 테스트 22 〉	통과 (19.81ms, 56.4MB)
// 테스트 23 〉	통과 (25.83ms, 56.7MB)
// 테스트 24 〉	통과 (19.95ms, 56.7MB)
// 테스트 25 〉	통과 (0.18ms, 33.6MB)
// 테스트 26 〉	통과 (0.17ms, 33.6MB)
// 테스트 27 〉	통과 (0.22ms, 33.6MB)
// 테스트 28 〉	통과 (7.22ms, 40.2MB)
// 테스트 29 〉	통과 (0.66ms, 34.6MB)
// 테스트 30 〉	통과 (8.79ms, 40.5MB)
