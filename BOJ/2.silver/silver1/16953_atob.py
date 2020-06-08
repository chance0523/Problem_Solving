# 16953번. A->B


a, b = map(int, input().split())

# b->a로 생각
# b가 짝수거나 마지막 자리수가 1인 수밖에 없다

cnt = 0
while True:
    if a > b:
        print(-1)
        break
    if a == b:
        print(cnt+1)
        break

    # b가 짝수
    if b % 2 == 0:
        b /= 2
    # 마지막 자리수가 1
    elif b % 10 == 1:
        b = b//10
    else:
        print(-1)
        break

    cnt += 1
