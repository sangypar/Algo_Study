class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.front = null;
    this.back = null;
    this.size = 0;
  }

  enqueue(val) {  // 추가
    const node = new Node(val);
    if (this.size == 0) {
      this.front = node;
      this.back = node;
    } else {
      this.back.next = node;
      this.back = node;
    }
    this.size++;
  }

  dequeue() {   // 제거
    if (this.isEmpty()) {
        throw new Error('큐가 비어있습니다.');
    }
    const val = this.front.val;
    this.front = this.front.next;
    this.size--;
    if (this.size === 0) {
      this.back = null;
    }
    return val;
  }

  peek() {
    if (this.isEmpty()) {
      throw new Error('큐가 비었습니다.');
    }
    return this.front.val;
  }

  isEmpty() {
    return this.size === 0;
  }
}


function solution(queue1, queue2) {
  let answer = -1;

  let lt = 0;
  let rt = 0;

  const Q1 = new Queue();
  const Q2 = new Queue();

  // 첫 번째 큐의 총합 계산 + Q1 생성
  for (let i = 0; i < queue1.length; i++) {
    lt += queue1[i];
    Q1.enqueue(queue1[i]);
  }

  // 두 번째 큐의 총합 계산 + Q2 생성
  for (let i = 0; i < queue2.length; i++) {
    rt += queue2[i];
    Q2.enqueue(queue2[i]);
  }

  for (let i = 0; i < queue1.length * 3; i++) {
    if (lt > rt) {
      lt -= Q1.peek();
      rt += Q1.peek();
      Q2.enqueue(Q1.dequeue());
    } else if (lt < rt) {
      rt -= Q2.peek();
      lt += Q2.peek();
      Q1.enqueue(Q2.dequeue());
    } else if (lt === rt) {
      answer = i;
      break;
    }
  }
  return answer;
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.25ms, 33.5MB)
// 테스트 2 〉	통과 (0.11ms, 33.4MB)
// 테스트 3 〉	통과 (0.24ms, 33.4MB)
// 테스트 4 〉	통과 (0.26ms, 33.4MB)
// 테스트 5 〉	통과 (0.35ms, 32.8MB)
// 테스트 6 〉	통과 (0.37ms, 33MB)
// 테스트 7 〉	통과 (0.36ms, 33.5MB)
// 테스트 8 〉	통과 (0.45ms, 33.5MB)
// 테스트 9 〉	통과 (0.63ms, 33.5MB)
// 테스트 10 〉	통과 (1.05ms, 33.7MB)
// 테스트 11 〉	통과 (36.50ms, 52MB)
// 테스트 12 〉	통과 (29.64ms, 44.3MB)
// 테스트 13 〉	통과 (20.38ms, 45.4MB)
// 테스트 14 〉	통과 (18.90ms, 47.8MB)
// 테스트 15 〉	통과 (33.32ms, 54MB)
// 테스트 16 〉	통과 (27.82ms, 54.1MB)
// 테스트 17 〉	통과 (26.77ms, 51.7MB)
// 테스트 18 〉	통과 (95.19ms, 82.1MB)
// 테스트 19 〉	통과 (84.81ms, 75.5MB)
// 테스트 20 〉	통과 (105.84ms, 82.4MB)
// 테스트 21 〉	통과 (97.34ms, 81.4MB)
// 테스트 22 〉	통과 (116.07ms, 87.6MB)
// 테스트 23 〉	통과 (116.70ms, 86.2MB)
// 테스트 24 〉	통과 (123.00ms, 92.4MB)
// 테스트 25 〉	통과 (0.39ms, 33.5MB)
// 테스트 26 〉	통과 (0.33ms, 33.6MB)
// 테스트 27 〉	통과 (0.34ms, 33.4MB)
// 테스트 28 〉	통과 (81.01ms, 66.9MB)
// 테스트 29 〉	통과 (3.57ms, 37.1MB)
// 테스트 30 〉	통과 (71.01ms, 65.4MB)