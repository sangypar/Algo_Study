function solution(jobs) {
    // 작업들을 요청 시간 기준으로 오름차순 정렬
    jobs.sort((a, b) => a[0] - b[0]);
    
    const heap = [];
    let time = 0;      // 현재 시간
    let total = 0;     // 총 걸린 시간
    let idx = 0;     // jobs 배열을 탐색하기 위한 인덱스
    
    const count = jobs.length; // 전체 작업의 수

    // 힙에 작업이 있거나, 아직 처리해야 할 작업이 남아있다면
    while (idx < count || heap.length > 0) {
        
        // 현재 시간 이전에 요청된 작업들을 힙에 추가
        while (idx < count && jobs[idx][0] <= time) {
            heap.push(jobs[idx]);
            idx++;
        }

        // 소요 시간이 짧은 순서대로 정렬 (최소 힙처럼 동작)
        heap.sort((a, b) => a[1] - b[1]);

        if (heap.length > 0) {
            // 가장 짧은 작업을 꺼내어 처리
            const [start, duration] = heap.shift();
            time += duration; // 작업이 끝나는 시간으로 업데이트
            total += time - start; // 요청부터 종료까지 걸린 시간 계산
        
        // 만약 처리할 작업이 없으면 다음 요청 시간으로 시간 이동
        } else time = jobs[idx][0];
    }
    
    return Math.floor(total / count);
}

/*
테스트 1 〉	통과 (4.72ms, 36.4MB)
테스트 2 〉	통과 (3.91ms, 36.4MB)
테스트 3 〉	통과 (4.15ms, 36.2MB)
테스트 4 〉	통과 (20.75ms, 36MB)
테스트 5 〉	통과 (4.48ms, 36.1MB)
테스트 6 〉	통과 (0.21ms, 33.1MB)
테스트 7 〉	통과 (2.91ms, 36MB)
테스트 8 〉	통과 (3.92ms, 35.7MB)
테스트 9 〉	통과 (0.51ms, 33.6MB)
테스트 10 〉	통과 (5.00ms, 36.4MB)
테스트 11 〉	통과 (0.17ms, 33.5MB)
테스트 12 〉	통과 (0.20ms, 33.6MB)
테스트 13 〉	통과 (0.20ms, 33.4MB)
테스트 14 〉	통과 (0.10ms, 33.6MB)
테스트 15 〉	통과 (0.10ms, 33.4MB)
테스트 16 〉	통과 (0.10ms, 33.4MB)
테스트 17 〉	통과 (0.10ms, 33.4MB)
테스트 18 〉	통과 (0.10ms, 33.5MB)
테스트 19 〉	통과 (0.09ms, 33.5MB)
테스트 20 〉	통과 (0.07ms, 33.4MB)
*/
