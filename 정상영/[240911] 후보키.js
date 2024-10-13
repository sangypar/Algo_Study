function solution(relation) {
    const n = relation.length;
    const m = relation[0].length;
    
    let answer = 0;
    
    const isDone = new Array(m).fill(false);
    
    // 하나의 어트리뷰트만으로 후보키가 가능한 경우 찾기
    for(let i = 0; i < m; i++) {
        const set = new Set();
        
        for(let j = 0; j < n; j++) {
            const tmp = relation[j][i];
            if(set.has(tmp)) break;
            else set.add(tmp);
        }
        if(set.size === n) {
            answer++;
            isDone[i] = true;
        }
    }
    
    for(let i = 0; i < m; i++) {
        if(isDone[i]) continue;
        
        const set = new Set();
        
        for(let j = i+1; j < m; j++) {
            if(isDone[j]) continue;
            
            for(let k = 0; k < n; k++) {
                
            }
        }
    }
    
    return isDone;
}
