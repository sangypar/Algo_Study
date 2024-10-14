function solution(array, commands) {
    const answer = [];
    
    for(let i = 0; i < commands.length; i++) {
        const tmp = [];
        
        for(let j = commands[i][0] - 1; j < commands[i][1]; j++) {
            tmp.push(array[j]);
        }
        
        tmp.sort((a, b) => a - b);
        
        answer.push(tmp[commands[i][2] - 1]);
    }
    
    return answer;
}
