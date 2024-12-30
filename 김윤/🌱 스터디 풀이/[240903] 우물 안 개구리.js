const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const weights = input[1].split(' ').map(Number);
let best = Array(N + 1).fill(true);

for (let i = 0; i < M; i++) {
    const [A, B] = input[i + 2].split(' ').map(Number);
    
    if (weights[A - 1] < weights[B - 1]) {
        best[A] = false;
    } else if (weights[A - 1] > weights[B - 1]) {
        best[B] = false;
    } else {
        best[A] = false;
        best[B] = false;
    }
}

let result = 0;
for (let i = 1; i <= N; i++) {
    if (best[i]) {
        result++;
    }
}

console.log(result);
