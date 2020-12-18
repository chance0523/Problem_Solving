# 1009번. 분산처리


import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a, b = map(int, input().split())
    ans = 1
    for i in range(b):  # a^b 계산
        ans *= a  # 곱해주고
        m = ans % 10 # 1의 자리수가 중요하다
        if m == 0: # 0이면 10
            ans = 10
        else:
            ans %=10
    print(ans)
