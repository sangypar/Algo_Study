class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        return answer;
    }
}

// 자바스크립트로 생각한 방식
// records split 으로 분할 / IN OUT 으로 입차 출차 파악
// 입차면 시간 * 60 + 분으로 바꾼다음 배열에 너허기
// 출차일 경우 시간을 계산한 다음
// 기본 시간 이하면면 기본 요금 / 기본 시간 초과면 기본 요금 + 추가 요금
// 차번호, 요금으로 묶은 배열 만든다음 넣기
// 차번호 기준으로 정렬하고 요금으로만 구성된 배열 만들어서 반환
