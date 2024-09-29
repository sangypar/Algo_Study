function solution(priorities, location) {
  // 우선순위와 index 함께 저장
  let queue = priorities.map((priority, index) => ({ priority, index }));
  let count = 0;

  while (queue.length > 0) {
    let current = queue.shift();
    // 남아있는 요소들 중 우선순위가 더 높은 요소가 있다면 push
    if (queue.some((item) => item.priority > current.priority)) {
      queue.push(current);
    } else {
      count++;
      if (current.index === location) {
        console.log(count);
        return count;
      }
    }
  }
}
