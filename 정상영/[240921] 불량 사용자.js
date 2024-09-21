function solution(user_id, banned_id) {
    const arr = new Array(banned_id.length).fill(null).map(() => []);
    
    // 경우의 수 찾기
    for(let i = 0; i < banned_id.length; i++) {
        const banName = banned_id[i];
        
        loop: for(let j = 0; j < user_id.length; j++) {
            const userName = user_id[j];
            
            // 길이가 다르면 패스
            if(banName.length !== userName.length) continue;
            
            for(let k = 0; k < userName.length; k++) {
                // 와일드 카드면 패스
                if(banName[k] === '*') continue;
                if(userName[k] !== banName[k]) continue loop;
            }
            
            // 밴 아이디와 유저 아이디가 일치하는 경우
            arr[i].push(j);
        }
    }
    const isUsed = new Array(user_id.length).fill(false);
    const set = new Set();
    
    const comb = ((idx, selected) => {
        // basecase
        if(idx === banned_id.length) {
            // 선택된 유저 인덱스를 정렬해서 문자열로 변환하여 중복 제거
            set.add(selected.slice().sort().join(','));
            return;
        }
        
        const curr = arr[idx];
        
        // recursive
        for(let i = 0; i < curr.length; i++) {
            if(!isUsed[curr[i]]) {
                isUsed[curr[i]] = true;
                comb(idx + 1, [...selected, curr[i]]);
                isUsed[curr[i]] = false;
            }
        }
    })
    
    comb(0, []);
    
    return set.size;
}

/*
정확성  테스트
테스트 1 〉	통과 (0.13ms, 33.4MB)
테스트 2 〉	통과 (0.29ms, 33.5MB)
테스트 3 〉	통과 (0.29ms, 33.6MB)
테스트 4 〉	통과 (0.32ms, 33.5MB)
테스트 5 〉	통과 (50.94ms, 37.8MB)
테스트 6 〉	통과 (1.44ms, 34.4MB)
테스트 7 〉	통과 (0.29ms, 33.5MB)
테스트 8 〉	통과 (0.29ms, 33.4MB)
테스트 9 〉	통과 (0.31ms, 33.5MB)
테스트 10 〉	통과 (0.26ms, 33.4MB)
테스트 11 〉	통과 (0.31ms, 33.5MB)
*/
