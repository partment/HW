#include <stdio.h>

int main() {

    int process_count;
    printf("請輸入Process數量（最多5）：");
    scanf("%d", &process_count);
    while (process_count > 5) {
        printf("Process數量最大值為5\n");
        printf("請輸入Process數量（最多5）：");
        scanf("%d", &process_count);
    }

    int instances[3];
    for (int i = 0; i < 3; i++) {
        printf("請輸入%c類資源的instance數量：", 65 + i);
        scanf("%d", &instances[i]);
    }

    int max[5][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            printf("請輸入%d號Process對%c類資源的需求數量：", j + 1, 65 + k);
            scanf("%d", &max[j][k]);
        }
    }

    int alloc[5][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            printf("請輸入系統快照時%d號Process對%c類資源的已佔用量：", j + 1, 65 + k);
            scanf("%d", &alloc[j][k]);
        }
    }

    int available[3];
    for (int i = 0; i < 3; i++) {
        available[i] = instances[i]; //將instances之值複製至available
    }
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            available[k] -= alloc[j][k]; //將instances減去已佔用的資源得到available
        }
    }

    int need[5][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            need[j][k] = max[j][k] - alloc[j][k]; //算出需求矩陣
        }
    }

    int finish[5] = {0, 0, 0, 0, 0}

    return 0;
}