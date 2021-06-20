# 수학은 체육과목 입니다 2


n = int(input())
if n <= 5:
    print(n)
else:
    if n % 2 == 0:
        n //= 4
        if n % 2 == 0:
            print(2)
        else:
            print(4)
    else:
        n //= 2
        if n % 2 == 1:
            print(3)
        else:
            n //= 2
            if n % 2 == 0:
                print(1)
            else:
                print(5)