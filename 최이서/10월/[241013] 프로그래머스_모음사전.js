function solution(word) {
  const vowels = ["A", "E", "I", "O", "U"];
  let count = 0;
  let found = false;

  function makeWord(cur) {
    count++;
    if (cur === word) {
      found = true;
      return;
    }

    if (cur.length === 5) return;

    // 각 모음에 대해 단어 생성
    for (let vowel of vowels) {
      if (found) return;
      makeWord(cur + vowel);
    }
  }

  makeWord("");

  return count - 1;
}
