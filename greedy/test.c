#include <stdio.h>

int main()
{
    int num1, num2;
    int sum;
    char c1;

    printf("수식을 입력하세요.");
    scanf("%d%c%d", &num1, &c1, &c1);

    if (c1 == '+')
    {
        sum = num1 + num2;
        printf("%d + %d = %d입니다.\n", num1, num2, sum);
    }
    else
    {
        printf("finished\n");
    }
    return 0;
}