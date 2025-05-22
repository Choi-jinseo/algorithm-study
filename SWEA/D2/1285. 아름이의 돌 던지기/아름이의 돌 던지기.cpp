#include <stdio.h>
#include <stdlib.h>

int main() {
    int T;
    scanf("%d", &T);
    
    for (int t = 1; t <= T; t++) {
        int N;
        scanf("%d", &N);

        int arr[100001] = {0};  // 0부터 100000까지
        
        for (int i = 0; i < N; i++) {
            int num;
            scanf("%d", &num);
            arr[abs(num)]++;
        }

        for (int i = 0; i <= 100000; i++) {
            if (arr[i] != 0) {
                printf("#%d %d %d\n", t, i, arr[i]);
                break;
            }
        }
    }
    
    return 0;
}
