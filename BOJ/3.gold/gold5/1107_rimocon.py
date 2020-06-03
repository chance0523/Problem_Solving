# 1107번. 리모컨


import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
check = {str(i) for i in range(10)}
if m:
    check = check-set(input().split())

ans = abs(n-100)

# 채널은 50만까지지만 그보다 큰 수부터 내려오는 것이
# 빠른 경우의 수도 있으므로 범위는 100만까지
for i in range(1000001):
    flag = True
    # 고장난 버튼이 포함 되어있으면 break
    for num in str(i):
        if num not in check:
            flag = False
            break
    if flag:
        # abs(n-i)+len(str(i)) 설명
        # len(str(i)) : 이만큼 숫자 버튼을 눌러서 그 채널로 이동
        # abs(n-i) : 남은 차이는 +,- 버튼으로 움직임
        ans = min(ans, abs(n-i)+len(str(i)))
print(ans)
