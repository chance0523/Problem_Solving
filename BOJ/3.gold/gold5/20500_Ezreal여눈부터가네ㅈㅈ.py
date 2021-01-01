# 20500번. Ezreal 여눈부터 가네 ㅈㅈ


def getComb(n, one, five):
    # 5 하나는 맨 뒤에 고정시켜놓고 조합 계산
    # one개와 five-1개의 조합
    r = min(one, five - 1)
    ja = 1
    mo = 1
    for i in range(n - 1, n - 1 - r, -1):
        ja *= i
    for i in range(1, r + 1):
        mo *= i
    return ja//mo


n = int(input())
mod = 1000000007
if n == 1:
    print(0)
elif n == 2:
    print(1)
else:
    ans = 0
    one = n - 1  # 1의 개수
    five = 1    # 5의 개수

    while True:
        if five == n + 1:
            print(ans % mod)
            break
        if (one+five*5) % 3 == 0:  # 15의 배수가 되는지 확인
            ans += getComb(n, one, five)  # 15의 배수를 만족하는 조합 더해주기
        one -= 1
        five += 1
