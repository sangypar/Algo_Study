function solution(fees, records) {
    
    const [basicTime, basicFee, timeBlock, feeBlock] = fees;
    
    let carIn = [];
    let carOut = [];
    
    for(let i = 0; i < records.length; i++){
        let nowCar = records[i].split(' ');
        
        if(nowCar[2] === 'IN') carIn.push({nowCar[1], nowCar[0]});
        else carOut.push(nowCar[1], nowCar[0]);
    }

    let answer = [];

    for(let i =0; i < carIn.length; i++) {
        let [carNumIn, carTimeIn] = carIn[i];
        
        for(let j = 0; j < carOut.length; j++){
            let [carNumOut, carTimeOut] = carIn[i];
            if(carNumOut === carNumIn) {
                //같은 차량번호가 있다면~ 출차 확인해야함
                let timeIn = carTimeIn.split(':');
                let timeOut = carTimeOut.splie(':');
                
                if(timeOut[1] - timeIn[1] >= 0) {
                    let time = timeOut[1] - timeIn[1] + (timeOut[0] - timeIn[0])*60;
                    //내림안해도 될때
                    answer.push({carNumIn : time});
                } else {
                    //내림해야될때
                    let time = -(timeOut[1] - timeIn[1]) + (timeOut[0] - 1 - timeIn[0])*60;
                    answer.push({carNumIn : time});
                }
                
                carOut[j]
                break; //그리고 찾았으면 다시 멈춰~!~!
            }
        }
        //출차기록이 없으면 여기서 처리해야하는데 아직 다 못풀었슴..
        
    }
    
    let answer = [];
    return answer;
}
