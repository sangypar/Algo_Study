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
    total *= closet[type] + 1;
  }

  // 아무 옷도 입지 않는 경우
  const result = total - 1;

  return result;
}

// 테스트
console.log(
  solution([
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"],
  ])
); // 5
console.log(
  solution([
    ["crow_mask", "face"],
    ["blue_sunglasses", "face"],
    ["smoky_makeup", "face"],
  ])
); // 3
