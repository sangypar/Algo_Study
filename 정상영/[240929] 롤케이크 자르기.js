function solution(topping) {
    
    const forwardSet = new Set;
    const backwardSet = new Set;
    
    const forwardArr = new Array(topping.length);
    const backwardArr = new Array(topping.length);
    
    
    for(let i = 0; i < topping.length; i++) {
        forwardSet.add(topping[i]);
        
        forwardArr[i] = forwardSet.size;
    }
    
    for(let i = topping.length - 1; i >= 0; i--) {
        backwardSet.add(topping[i]);
        
        backwardArr[i] = backwardSet.size;
    }
    
    let ans = 0;
    
    for(let i = 0; i < topping.length - 1; i++) {
        if(forwardArr[i] === backwardArr[i+1]) ans++;
    }
    
    return ans;
}

/*
테스트 1 〉	통과 (3.39ms, 37.1MB)
테스트 2 〉	통과 (19.73ms, 41.1MB)
테스트 3 〉	통과 (13.03ms, 39.6MB)
테스트 4 〉	통과 (9.21ms, 39.4MB)
테스트 5 〉	통과 (39.85ms, 76.6MB)
테스트 6 〉	통과 (72.53ms, 81MB)
테스트 7 〉	통과 (67.82ms, 81MB)
테스트 8 〉	통과 (67.07ms, 81.1MB)
테스트 9 〉	통과 (83.57ms, 80.7MB)
테스트 10 〉	통과 (68.61ms, 80.7MB)
테스트 11 〉	통과 (12.88ms, 39.5MB)
테스트 12 〉	통과 (4.49ms, 38.3MB)
테스트 13 〉	통과 (80.07ms, 81MB)
테스트 14 〉	통과 (65.35ms, 79.3MB)
테스트 15 〉	통과 (79.03ms, 79.3MB)
테스트 16 〉	통과 (71.30ms, 79.3MB)
테스트 17 〉	통과 (67.60ms, 79.3MB)
테스트 18 〉	통과 (74.74ms, 79.3MB)
테스트 19 〉	통과 (71.21ms, 79.3MB)
테스트 20 〉	통과 (72.37ms, 79.3MB)
*/
