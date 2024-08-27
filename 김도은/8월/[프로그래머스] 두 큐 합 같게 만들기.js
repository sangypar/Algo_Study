function solution(queue1, queue2) {
    let answer = 0;
    
    let queueSum1 = 0;
    queue1.forEach((element) => queueSum1 += element);
    
    let queueSum2 = 0;
    queue2.forEach((element) => queueSum2 += element);
    
    let len = queue1.length + queue2.length;
    
    let queueIdx1 = 0;
    let queueIdx2 = 0;
    
    while(queueSum1 !== queueSum2) {
        if(queueIdx1 > len || queueIdx2 > len) return -1; //절대안됨
        
        if(queueSum1>queueSum2){
            queueSum1 -= queue1[queueIdx1];
            queue2.push(queue1[queueIdx1]);
            queueSum2 +=queue1[queueIdx1++];
        } else{
             queueSum1 += queue2[queueIdx2];
             queue1.push(queue2[queueIdx2]);
             queueSum2 -=queue2[queueIdx2++];
        }
        
        answer++;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.07ms, 33.4MB)
// 테스트 2 〉	통과 (0.07ms, 33.4MB)
// 테스트 3 〉	통과 (0.25ms, 33.4MB)
// 테스트 4 〉	통과 (0.14ms, 33.4MB)
// 테스트 5 〉	통과 (0.16ms, 33.3MB)
// 테스트 6 〉	통과 (0.16ms, 33.4MB)
// 테스트 7 〉	통과 (0.18ms, 33.4MB)
// 테스트 8 〉	통과 (0.18ms, 33.4MB)
// 테스트 9 〉	통과 (0.22ms, 33.4MB)
// 테스트 10 〉	통과 (0.30ms, 33.5MB)
// 테스트 11 〉	통과 (31.12ms, 42.6MB)
// 테스트 12 〉	통과 (25.36ms, 38.1MB)
// 테스트 13 〉	통과 (18.17ms, 39.7MB)
// 테스트 14 〉	통과 (4.58ms, 40.6MB)
// 테스트 15 〉	통과 (22.11ms, 41.9MB)
// 테스트 16 〉	통과 (15.16ms, 42.1MB)
// 테스트 17 〉	통과 (5.18ms, 39.7MB)
// 테스트 18 〉	통과 (13.53ms, 54.1MB)
// 테스트 19 〉	통과 (15.64ms, 55.3MB)
// 테스트 20 〉	통과 (22.71ms, 56.1MB)
// 테스트 21 〉	통과 (23.58ms, 56.4MB)
// 테스트 22 〉	통과 (28.89ms, 56.7MB)
// 테스트 23 〉	통과 (26.04ms, 56.5MB)
// 테스트 24 〉	통과 (28.98ms, 56.8MB)
// 테스트 25 〉	통과 (0.18ms, 33.4MB)
// 테스트 26 〉	통과 (0.17ms, 33.4MB)
// 테스트 27 〉	통과 (0.17ms, 33.4MB)
// 테스트 28 〉	통과 (16.87ms, 49.3MB)
// 테스트 29 〉	통과 (0.95ms, 35.9MB)
// 테스트 30 〉	통과 (18.52ms, 47.6MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
