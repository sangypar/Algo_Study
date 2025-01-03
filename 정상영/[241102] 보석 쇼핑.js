function solution(gems) {
    const gemsType = new Set(gems).size;
    const map = new Map();
    let start = 0, end = 0;
    let answer = [start, gems.length - 1];
    
    // end가 배열의 끝에 닿을 때까지
    while(end < gems.length) {
        // 현재 보석 맵에 추가
        map.set(gems[end], (map.get(gems[end]) || 0) + 1);
        end++;
        
        // 모든 보석이 포함되어 있다면
        while(map.size === gemsType) {
            // 현재 구간이 그 동안 찾았던 구간보다 짧다면
            if(end - start - 1 < answer[1] - answer[0]) {
                answer = [start, end - 1];
            }
            
            // 모든 보석이 포함되지 않을 때 까지 앞에서부터 제거
            map.set(gems[start], map.get(gems[start]) - 1);
            if(map.get(gems[start]) === 0) {
                map.delete(gems[start]);
            }
            
            start++;
        }
    }
    
    return [answer[0] + 1, answer[1] + 1];
}
