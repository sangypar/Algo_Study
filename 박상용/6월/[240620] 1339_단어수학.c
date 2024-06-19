#define _CRT_SECURE_NO_WARNINGS // 보안 문제로 scanf를 사용할 때 사용
#include<stdio.h>
#include<string.h> // strlen 때문에 해당 라이브러리 사용
#include<math.h> // pow 때문에 해당 라이브러리 사용

int arr[26]; // 알파벳 26자

int compare(int* a, int* b) {
	return *b - *a; // 내림차순 정렬
}

int main() {
	int n; // 단어의 개수
	int res = 0; // 결과값 담을 변수
	char num[10]; // 단어의 크기는 9자리 이하
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%s", num);
		int len = strlen(num); // 입력받은 숫자의 길이 저장
		for (int j = 0; j < len; j++) {
			int tmp = num[j] - 'A'; // j번째 자리가 어떤 숫자인지 판별
			arr[tmp] += pow(10, len - 1 - j); // 크기 만큼 넣어주기
		}
	}

	qsort(arr, 26, sizeof(int), compare); // qsort(배열, 요소의 개수, 요소의 크기, 기준 함수)

	for (int i = 9; i > 0; i--) 
		res += arr[(9-i)] * i;

	printf("%d", res); // 출력
}