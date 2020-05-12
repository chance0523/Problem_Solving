# 10610번. 30

# hint. 30의 배수는 자리 수를 다 더해서
# 3의 배수가 되고, 맨 끝자리가 0이면 된다.


def calp(N):
    N = sorted(N, reverse=True)  # max
    sum = 0
    if '0' not in N:  # 0이 없으면 꽝
        return -1
    else:
        for num in N:
            sum += int(num)
        if sum % 3 != 0:
            return -1
        else:
            return "".join(N)


N = input()

print(calp(N))
