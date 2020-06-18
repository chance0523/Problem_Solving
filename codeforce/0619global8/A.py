import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    a, b, n = map(int, input().split())
    ans = 0
    M = max(a, b)
    '''
    5 4
    9 4 / 5 9
    '''
    while n >= M:
        # 두 개 합이 큰 것으로 계속 가면 됨
        if (a+b)+b > a+(a+b):
            a += b
        else:
            b += a
        M = max(a, b)
        ans += 1
    print(ans)
