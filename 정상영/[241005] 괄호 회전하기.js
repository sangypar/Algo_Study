function solution(s) {
    let answer = 0;
    const pairs = { ')': '(', '}': '{', ']': '[' };

    const check = (arr) => {
        const stack = [];
        for (let ch of arr) {
            if (['[', '(', '{'].includes(ch)) {
                stack.push(ch);
            } else {
                if (stack.pop() !== pairs[ch]) return false;
            }
        }
        return stack.length === 0;
    }

    const input = s.split("");
    
    if (input.length % 2 === 1) return 0;
    
    for (let i = 0; i < input.length; i++) {
        if (check(input)) answer++;
        input.push(input.shift());
    }

    return answer;
}


/*
테스트 1 〉	통과 (4.22ms, 37.3MB)
테스트 2 〉	통과 (3.62ms, 36.9MB)
테스트 3 〉	통과 (5.11ms, 36.7MB)
테스트 4 〉	통과 (4.91ms, 37.2MB)
테스트 5 〉	통과 (6.54ms, 37MB)
테스트 6 〉	통과 (4.06ms, 37MB)
테스트 7 〉	통과 (4.61ms, 37.2MB)
테스트 8 〉	통과 (4.03ms, 37.1MB)
테스트 9 〉	통과 (4.82ms, 37.4MB)
테스트 10 〉	통과 (6.80ms, 37.4MB)
테스트 11 〉	통과 (8.50ms, 37.8MB)
테스트 12 〉	통과 (0.07ms, 33.4MB)
테스트 13 〉	통과 (0.11ms, 33.5MB)
테스트 14 〉	통과 (0.11ms, 33.6MB)
*/
