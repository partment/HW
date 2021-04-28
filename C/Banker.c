#define PROC_MAX_COUNT 5
#include <stdio.h>

void permute(int *arr, int *possibilities_ptr, int st, int ls, int *counter_ptr);
int factorial(int n);

int main() {

    //設定Process的數量
    int process_count;
    printf("請輸入Process數量（最多%d）：", PROC_MAX_COUNT);
    scanf("%d", &process_count);
    while (process_count > PROC_MAX_COUNT) {
        printf("Process數量最大值為%d\n", PROC_MAX_COUNT);
        printf("請輸入Process數量（最多%d）：", PROC_MAX_COUNT);
        scanf("%d", &process_count);
    }

    int factorial_num = factorial(process_count); //利用階乘求順序的總數

    //設定各類資源的數量
    int instances[3];
    for (int i = 0; i < 3; i++) {
        printf("請輸入%c類資源的instance數量：", 65 + i);
        scanf("%d", &instances[i]);
    }

    //設定各Process的最大需求數量
    int max[PROC_MAX_COUNT][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            printf("請輸入%d號Process對%c類資源的最大需求數量：", j + 1, 65 + k);
            scanf("%d", &max[j][k]);
        }
    }

    //設定各Process已佔用的資源數量
    int alloc[PROC_MAX_COUNT][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            printf("請輸入系統快照時%d號Process對%c類資源的已佔用量：", j + 1, 65 + k);
            scanf("%d", &alloc[j][k]);
        }
    }

    //算快照時的資源可用數
    int available[3];
    for (int i = 0; i < 3; i++) {
        available[i] = instances[i]; //將instances之值複製至available
    }
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            available[k] -= alloc[j][k]; //將instances減去已佔用的資源得到available
        }
    }

    //算出需求矩陣
    int need[PROC_MAX_COUNT][3];
    for (int j = 0; j < process_count; j++) {
        for (int k = 0; k < 3; k++) {
            need[j][k] = max[j][k] - alloc[j][k]; //需求 = 最大 - 已佔用
        }
    }

    //判斷系統是否安全
    int finish[PROC_MAX_COUNT];
    for(int i = 0;i < process_count;i++) {
        finish[i] = 0; //Initialize
    }
    for(int j = 0;j < process_count;j++) {
        if(finish[j] == 0) { //如果沒做完才繼續判斷
            for (int k = 0; k < 3; k++) {
                if(need[j][k] > available[k]) { //如果需求大於可用
                    finish[j] = 0;
                    break;
                }else { //如果需求小於等於可用
                    finish[j] = 1;
                }
            }
        }
        if(finish[j] == 1) {
            for (int i = 0; i < 3; i++) {
                available[i] += alloc[j][i]; //釋放資源
            }
        }
    }

    //全部finish = 1才算安全
    int safe = 0;
    for(int i = 0;i < process_count;i++) {
        if(finish[i] == 1) {
            safe = 1;
        }else {
            safe = 0;
            break;
        }
    }
    if(safe) {
        printf("\n這個系統是安全的\n\n");
    }else {
        printf("\n這個系統是不安全的");
        return 0;
    }

    //Permute所有順序可能存至possibilities裡面，並逐一Eval
    int process[PROC_MAX_COUNT];
    for(int i = 0;i < PROC_MAX_COUNT;i++) {
        process[i] = i;
    }
    int possibilities[5040][PROC_MAX_COUNT];
    for(int j = 0; j < 5040;j++) {
        for(int k = 0;k < process_count;k++) {
            possibilities[j][k] = 0;
        }
    }
    int *possibilities_ptr = possibilities[0];
    int counter = 0;
    int *counter_ptr = &counter;
    permute(process, possibilities_ptr, 0, process_count, counter_ptr); //開始排列所有可能的順序

    int safe_counter = 0;
 
    //Start to evaluate all permutations
    printf("以下的順序是安全的\n\n");
    for(int j = 0; j < factorial_num;j++) {
        //Initialize finish and available
        for(int i = 0;i < process_count;i++) {
            finish[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            available[i] = instances[i]; //將instances之值複製至available
        }
        for (int p = 0; p < process_count; p++) {
            for (int k = 0; k < 3; k++) {
                available[k] -= alloc[p][k]; //將instances減去已佔用的資源得到available
            }
        }

        //Start to evaluate this sequence is safe or not  
        for(int k = 0;k < process_count;k++) {
            if(finish[possibilities[j][k]] == 0) { //j = one of permutations, k = one of process in this permutation
                for (int p = 0; p < 3; p++) {
                    if(need[possibilities[j][k]][p] > available[p]) { //如果需求大於可用
                        finish[possibilities[j][k]] = 0;
                        break;
                    }else { //如果需求小於等於可用
                        finish[possibilities[j][k]] = 1;
                    }
                }
            }
            if(finish[possibilities[j][k]] == 1) {
                for (int i = 0; i < 3; i++) {
                    available[i] += alloc[possibilities[j][k]][i]; //釋放資源
                }
            }
        }

        //在這個permutation當中的所有Process其finish = 1才算安全
        safe = 0;
        for(int i = 0;i < process_count;i++) {
            if(finish[i] == 1) {
                safe = 1;
            }else {
                safe = 0;
                break;
            }
        }
        if(safe == 1) {
            for(int k = 0;k < process_count;k++) {
                printf("%d", possibilities[j][k]+1);
                if(k < process_count - 1) {
                    printf("->");
                }else {
                    printf("\n");
                }
            }
            safe_counter++;
        }
    }
    printf("\n在總共 %d 個順序中有 %d 個順序是安全的", factorial_num, safe_counter);
    return 0;
}

void swap(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}
void permute(int *arr, int *possibilities_ptr, int st, int ls, int *counter_ptr) {
    if(st==ls) {
        for(int k = 0;k < ls;k++) {
            *(possibilities_ptr+*counter_ptr*PROC_MAX_COUNT+k) = *(arr+k);
        }
        *counter_ptr += 1;
    }else {
        for(int i = st;i < ls;i++) {
            swap(arr+st, arr+i);
            permute(arr, possibilities_ptr, st+1, ls, counter_ptr);
            swap(arr+st, arr+i);
        }
    }
}

int factorial(int n) {
    if (n <= 1) {
        return 1;
    }else {
        return n * factorial(n-1);
    }
}