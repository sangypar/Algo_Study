#include <stdio.h>

int arr[9999999];

int find(int num) {
    if (arr[num] == num)
        return num;
    else 
        return arr[num] = find(arr[num]);
    
}

void uni(int num1, int num2) {
    num1 = find(num1);
    num2 = find(num2);

    if (num1 != num2) 
        arr[num2] = num1;
}

int main() {
    int n, m;
    scanf_s("%d %d", &n, &m);

    for (int i = 1; i <= n; i++) 
        arr[i] = i;

    for (int i = 0; i < m; i++) {
        int op, a, b;
        scanf_s("%d %d %d", &op, &a, &b);

        if (op == 0) 
            uni(a, b);
        else {
            if (find(a) == find(b)) 
                printf("YES\n");
            else 
                printf("NO\n");
        }
    }

}
