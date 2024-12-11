///////////////////////imos 알고리즘
function solution(book_time) {
    // 시간을 분으로 변환하는 함수
    const timeToMinutes = (time) => {
        const [hour, minute] = time.split(":").map(Number); //타입변환
        return hour * 60 + minute;
    };
    
     const rooms = [];

    // 예약 정보를 이벤트로 변환
    book_time.forEach(([start, end]) => {
        const startTime = timeToMinutes(start);
        const endTime = timeToMinutes(end) + 10; // 청소 시간 10분 포함
        
        rooms.push({ time: startTime, type: 'start' });
        rooms.push({ time: endTime, type: 'end' });
    });

    // 시간 기준으로 이벤트 정렬 (같은 시간의 경우 'end' 이벤트가 먼저 처리되도록)
    rooms.sort((a, b) => a.time - b.time || a.type.localeCompare(b.type));
    
    let currentRooms = 0;
    let maxRooms = 0;

    // 이벤트 처리
    rooms.forEach(room => {
        if (room.type === 'start') {
            currentRooms += 1;
            maxRooms = Math.max(maxRooms, currentRooms);
        } else if (room.type === 'end') {
            currentRooms -= 1;
        }
    });

    return maxRooms;
}

// 테스트 1 〉	통과 (9.54ms, 36MB)
// 테스트 2 〉	통과 (9.43ms, 36.2MB)
// 테스트 3 〉	통과 (12.04ms, 36.8MB)
// 테스트 4 〉	통과 (10.33ms, 36.5MB)
// 테스트 5 〉	통과 (0.16ms, 33.6MB)
// 테스트 6 〉	통과 (11.57ms, 36.8MB)
// 테스트 7 〉	통과 (11.23ms, 36.8MB)
// 테스트 8 〉	통과 (36.39ms, 36.2MB)
// 테스트 9 〉	통과 (10.20ms, 36.2MB)
// 테스트 10 〉	통과 (10.63ms, 36.6MB)
// 테스트 11 〉	통과 (12.29ms, 39.1MB)
// 테스트 12 〉	통과 (12.10ms, 36.9MB)
// 테스트 13 〉	통과 (9.37ms, 36.1MB)
// 테스트 14 〉	통과 (11.35ms, 36.8MB)
// 테스트 15 〉	통과 (12.06ms, 36.8MB)
// 테스트 16 〉	통과 (10.01ms, 36.3MB)
// 테스트 17 〉	통과 (12.21ms, 39.1MB)
// 테스트 18 〉	통과 (10.72ms, 36.6MB)
// 테스트 19 〉	통과 (26.64ms, 40MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0

// 자스는 일반 풀이가 더 빠르네....

////////////////////일반 풀이
function solution(book_time) {
    
    // 시간을 분으로 변환하는 함수
    const timeToMinutes = (time) => {
        const [hour, minute] = time.split(":").map(Number); //타입변환
        return hour * 60 + minute;
    };

    // 각 예약의 시작 시간과 종료 시간을 분 단위로 변환
    const times = book_time.map(([start, end]) => [timeToMinutes(start), timeToMinutes(end)]);

    // 시작 시간이 빠른 순서로 정렬
    times.sort((a, b) => a[0] - b[0]);

    const rooms = [];

    for (const [start, end] of times) {
        let placed = false;
        
        // 각 방을 확인하여 현재 예약을 넣을 수 있는지 확인
        for (let i = 0; i < rooms.length; i++) {
            if (rooms[i] <= start) {
                // 현재 방에 새 예약 배정 (기존 예약 종료 시간 + 청소 시간)
                rooms[i] = end + 10;
                placed = true;
                break;
            }
        }

        // 현재 예약을 배정할 방이 없으면 새로운 방 추가
        if (!placed) {
            rooms.push(end + 10);
        }
    }

    // 필요한 방의 개수 반환
    return rooms.length;
}


// 테스트 1 〉	통과 (0.35ms, 33.5MB)
// 테스트 2 〉	통과 (0.99ms, 33.7MB)
// 테스트 3 〉	통과 (7.32ms, 37.6MB)
// 테스트 4 〉	통과 (6.12ms, 37.2MB)
// 테스트 5 〉	통과 (0.12ms, 33.5MB)
// 테스트 6 〉	통과 (5.83ms, 37.4MB)
// 테스트 7 〉	통과 (7.43ms, 37.8MB)
// 테스트 8 〉	통과 (1.62ms, 33.8MB)
// 테스트 9 〉	통과 (1.11ms, 33.7MB)
// 테스트 10 〉	통과 (5.38ms, 37.3MB)
// 테스트 11 〉	통과 (6.37ms, 37.7MB)
// 테스트 12 〉	통과 (48.20ms, 37.7MB)
// 테스트 13 〉	통과 (0.83ms, 33.8MB)
// 테스트 14 〉	통과 (5.99ms, 37.5MB)
// 테스트 15 〉	통과 (6.10ms, 37.6MB)
// 테스트 16 〉	통과 (1.65ms, 33.8MB)
// 테스트 17 〉	통과 (6.23ms, 37.6MB)
// 테스트 18 〉	통과 (5.46ms, 37.4MB)
// 테스트 19 〉	통과 (5.97ms, 37.7MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
