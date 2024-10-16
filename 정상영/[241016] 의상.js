function solution(clothes) {
    const clothMap = {};
    
    for(cloth of clothes) {
        const [item, type] = cloth;
        
        if(clothMap.hasOwnProperty(type)) {
            clothMap[type]++;
        } else {
            clothMap[type] = 1;
        }
    }
    
    let answer = 1;
    
    for(const value of Object.values(clothMap)) {
        answer *= value + 1;
    }
    
    return answer - 1;
}
