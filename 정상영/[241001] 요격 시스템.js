function solution(targets) {
    targets.sort((a, b) => a[1] - b[1]);
    
    let cnt = 0;
    let prevEnd = 0;
    
    for(let i = 0; i < targets.length; i++) {
        if(targets[i][0] >= prevEnd) {
            cnt++;
            prevEnd = targets[i][1];
        }
    }
    
    return cnt;
}

/*
테스트 1 〉	통과 (0.05ms, 33.5MB)
테스트 2 〉	통과 (0.14ms, 33.5MB)
테스트 3 〉	통과 (0.16ms, 33.5MB)
테스트 4 〉	통과 (0.67ms, 33.7MB)
테스트 5 〉	통과 (4.60ms, 38.2MB)
테스트 6 〉	통과 (48.65ms, 54.7MB)
테스트 7 〉	통과 (395.82ms, 165MB)
테스트 8 〉	통과 (411.93ms, 165MB)
테스트 9 〉	통과 (490.81ms, 161MB)
테스트 10 〉	통과 (16.52ms, 136MB)
테스트 11 〉	통과 (0.06ms, 33.4MB)
*/
