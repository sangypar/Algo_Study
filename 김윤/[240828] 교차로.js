const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  // 개수 처리
  const count = parseInt(input[0]);

  const A = [];
  const B = [];
  const C = [];
  const D = [];

  // 입력값 처리
  for (let i = 1; i <= count; i++) {
    const [num, direction] = input[i].split(" ");

    if (direction === "A") A.push({ id: num, direction });
    else if (direction === "B") B.push({ id: num, direction });
    else if (direction === "C") C.push({ id: num, direction });
    else D.push({ id: num, direction });
  }

  let congestion = false;

  function intersection() {
    if (!congestion) {
      if (A.length !== 0) {
        const enteringCar = A.shift();
        congestion = true;
        setTimeout(() => {
          congestion = false;
          intersection();
        }, 1000);
      } else if (B.length !== 0) {
        const enteringCar = B.shift();
        congestion = true;
        setTimeout(() => {
          congestion = false;
          intersection();
        }, 1000);
      } else if (C.length !== 0) {
        const enteringCar = C.shift();
        congestion = true;
        setTimeout(() => {
          congestion = false;
          intersection();
        }, 1000);
      } else if (D.length !== 0) {
        const enteringCar = D.shift();
        congestion = true;
        setTimeout(() => {
          congestion = false;
          intersection();
        }, 1000);
      } else {
        process.exit();
      }
    }
  }

  intersection();
});
