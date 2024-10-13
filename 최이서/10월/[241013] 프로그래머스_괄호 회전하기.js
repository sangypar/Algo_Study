function solution(s) {
  let count = 0; // 회전 시 올바른 괄호 문자열이 되는 x의 개수

  for (let i = 0; i < s.length; i++) {
    if (isValid(s)) {
      count++;
    }
    s = s.slice(1) + s[0]; // 문자열 회전
  }

  return count;
}

function isValid(str) {
  const stack = [];
  const left = ["(", "[", "{"];
  const right = [")", "]", "}"];

  for (let char of str) {
    if (left.includes(char)) {
      stack.push(char);
    } else if (right.includes(char)) {
      if (stack.length === 0) return false;

      let lastOpen = stack.pop();
      if (left.indexOf(lastOpen) !== right.indexOf(char)) {
        return false;
      }
    }
  }
  return stack.length === 0;
}

solution("[](){}");
solution("}]()[{");
solution("[)(]");
solution("}}}");
