#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
    int T;
    scanf("%d", &T);
    
    for (int t = 0; t < T; t++) {
        int N, M;
        scanf("%d %d", &N, &M);
        
        bool f[100][100];
        bool a[100] = {false};
        bool b[100] = {false};
        char str[105];
        
        for (int i = 0; i < N; i++) {
            scanf("%s", str);
            for (int j = 0; j < M; j++) {
                f[i][j] = (str[j] == '1');
            }
        }
        if (f[0][0]) {
            a[0] = true;
            b[0] = true;
        } else {
            a[0] = true;
            b[0] = false;
        }
        
        for (int i = 1; i < N; i++) {
            if (f[i][0])
                a[i] = b[0];
            else
                a[i] = !b[0];
        }

        for (int j = 1; j < M; j++) {
            if (f[0][j])
                b[j] = a[0];
            else
                b[j] = !a[0];
        }
        bool flag = false;
        for (int i = 1; i < N && !flag; i++) {
            for (int j = 1; j < M; j++) {
                if ((f[i][j] && a[i] != b[j]) || (!f[i][j] && a[i] == b[j])) {
                    flag = true;
                    break;
                }
            }
        }
        printf("#%d %s\n", t + 1, flag ? "no" : "yes");
    }

    return 0;
}
