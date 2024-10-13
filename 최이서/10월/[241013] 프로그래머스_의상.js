function solution(clothes) {
  const closet = {};

  // 종류 별 개수 계산
  for (let i = 0; i < clothes.length; i++) {
    const clothType = clothes[i][1];

    if (closet[clothType] === undefined) {
      // 처음 나오는 경우: 1
      closet[clothType] = 1;
    } else {
      // 이미 존재하는 경우: +1
      closet[clothType] += 1;
    }
  }

  let total = 1;

  for (let type in closet) {
    // '+1'은 해당 종류의 의상을 입지 않는 경우를 포함합니다.
    total *= closet[type] + 1;
  }

  // 아무 옷도 입지 않는 경우
  const result = total - 1;

  return result;
}
