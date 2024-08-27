// readline 모듈 import
const readline = require("readline");

// 입출력을 위한 인터페이스 객체 생성
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let N = 0;
const inputLines = [];

rl.on('line', (line) => {
  if (N === 0) {
    N = parseInt(line);
  } else {
      inputLines.push(line);
      if (inputLines.length === N) {
          rl.close();
      }
  }
});

rl.on('close', () => {
  // console.log("Number of Lines:", numberOfLines);
  // console.log("Input Lines:", inputLines);

  const processedData = inputLines.map(line => {
    const [number, char] = line.split(' ');
    return { number: parseInt(number), char: char };
  });

  let cars = [[], [], [], []];
  let time = inputLines[0][0];
  
  for (let i = 0; i < N; i++) {
    if (inputLines[i][0] !== time) {
      
    }
    if (inputLines[i][0] === time) {
      switch (inputLines[i][1]) {
        case 'A':
          cars[0].push(inputLines[i][0]);
          break;
        case 'B':
          cars[1].push(inputLines[i][0]);
          break;
        case 'C':
          cars[2].push(inputLines[i][0]);
          break;
        case 'D':
          cars[3].push(inputLines[i][0]);
          break;
      }
    } else {
      drive();

    }
  };

  const drive = () => {

  };
  // console.log("Processed Data:", processedData);

});