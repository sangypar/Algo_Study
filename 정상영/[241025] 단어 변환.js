function solution(begin, target, words) {
    let answer = 123456789;

    // words에 없으면
    if (!words.includes(target)) return 0;

    const visited = new Array(words.length).fill(false);

    // 두 단어가 한 글자 차이인지 확인하는 함수
    const isOneCharDiff = (word1, word2) => {
        let diffCount = 0;
        for (let i = 0; i < word1.length; i++) {
            if (word1[i] !== word2[i]) diffCount++;
            if (diffCount > 1) return false;
        }
        return diffCount === 1;
    };

    const dfs = (cnt, word) => {
        if (word === target) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (let i = 0; i < words.length; i++) {
            if (!visited[i] && isOneCharDiff(word, words[i])) {
                visited[i] = true;
                dfs(cnt + 1, words[i]);
                visited[i] = false;
            }
        }
    };

    dfs(0, begin);

    return answer === 123456789 ? 0 : answer;
}
