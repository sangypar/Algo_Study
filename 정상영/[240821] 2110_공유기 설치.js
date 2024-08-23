const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const input = fs.readFileSync('test.txt').toString().trim().split('\n').map(line => line.trim());

// 조합 풀이 (메모리 초과)
// function solution(arr) {
//     const houses = parseInt(arr[0].split(" ")[0]);
//     const routers = parseInt(arr[0].split(" ")[1]);

//     const coords = [];
//     for(let i = 1; i <= houses; i++) {
//         coords.push(arr[i]);
//     }

//     coords.sort((a, b) => a - b);

//     // 조합
//     const comb = (arr, n) => {
//         const results = [];

//         if(n === 1) {
//             return arr.map((el) => [el]);
//         }

//         arr.forEach((fixed, idx, origin) => {
//             const rest = origin.slice(idx + 1);
//             const combination = comb(rest, n-1);
//             const attached = combination.map((el) => [fixed, ...el]);
            
//             results.push(...attached);
//         })

//         return results;
//     }
    
//     let answer = Number.MIN_SAFE_INTEGER;
    
//     // 인접 거리가 가장 먼 조합 찾기
//     const find = (arr) => {
        
//         arr.forEach((arrEl) => {
//             let minDist = Number.MAX_SAFE_INTEGER;
            
//             for(let i = 0; i < arrEl.length-1; i++) {
//                 const dist = Math.abs(arrEl[i] - arrEl[i+1]);
//                 minDist = Math.min(minDist, dist);
//             }
            
//             answer = Math.max(answer, minDist);
//         })

//         return answer;
//     }

//     return find(comb(coords, routers));
// }

// 이진 탐색 풀이
function solution(arr) {
    const houses = parseInt(arr[0].split(" ")[0]);
    const routers = parseInt(arr[0].split(" ")[1]);

    const coords = [];
    for (let i = 1; i <= houses; i++) {
        coords.push(parseInt(arr[i]));
    }

    coords.sort((a, b) => a - b);

    // 이 거리로 공유기가 설치 가능한가?
    const canPlaceRouters = (minDist) => {
        let count = 1;
        let lastPlaced = coords[0];

        for (let i = 1; i < coords.length; i++) {
            if (coords[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = coords[i];
            }
            if (count >= routers) {
                return true;
            }
        }
        return false;
    }

    let low = 1;
    let high = coords[coords.length - 1] - coords[0];
    let answer = 0;

    // 이진 탐색
    while (low <= high) {
        const mid = Math.floor((low + high) / 2);

        if (canPlaceRouters(mid)) {
            answer = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return answer;
}

console.log(solution(input));