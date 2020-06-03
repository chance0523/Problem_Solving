# 1676번. 팩토리얼 0의 개수


import sys
input = sys.stdin.readline

n = int(input())

f = 1
for i in range(1, n+1):
    f *= i
# 숫자를 한 자리 한 자리
# 리스트 형태로 만들어줘서 맨 뒤부터 체크
f = list(str(f))

ans = 0
for i in range(len(f)-1, -1, -1):
    if f[i] == '0':
        ans += 1
    else:
        break
print(ans)
