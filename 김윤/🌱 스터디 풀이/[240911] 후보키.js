function solution(relation) {
    let [rowCount, colCount] = [relation.length, relation[0].length];
    let candidateKeys = [];
    
    // 조합
    
    // 유일성 체크
    const isUnique = (combination) => {
        const set = new Set();
        for (let row of relation) {
            const key = combination.map((colIndex) => row[colIndex].join(','));
            set.add(key);
        }
        return set.size === rowCount;
    }
    
    // 최소성 체크
    const isMinmal = (combination) => {
        return candidateKeys.every((key) => key.every((col) => coombination.includes(col)));
    }
    
    // 조합 탐색
    
    return candidateKeys.length;
}
