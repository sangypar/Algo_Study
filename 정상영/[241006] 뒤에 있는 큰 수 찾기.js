function solution(numbers) {
    const answer = Array(numbers.length).fill(-1);
    const stack = [];
    
    for (let i = 0; i < numbers.length; i++) {
        // 스택에 저장된 인덱스들의 값을 확인하며, 현재 값보다 작은 값을 만날 때마다 그 값을 교체
        while (stack.length > 0 && numbers[stack[stack.length - 1]] < numbers[i]) {
            const idx = stack.pop();
            answer[idx] = numbers[i];
        }
        stack.push(i);  // 현재 인덱스를 스택에 저장
    }
    
    return answer;
}

/*
