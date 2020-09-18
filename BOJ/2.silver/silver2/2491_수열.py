# 2491번. 수열


import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int, input().split()))

inc = 1  # 증가하는 구간 길이
dec = 1  # 감소하는 구간 길이
ans = 1  # 배열 길이가 1이라면 답은 1

for i in range(n-1):
    if nList[i] < nList[i+1]:  # 증가
        inc += 1  # 증가구간 길이++
        ans = max(ans, inc)  # 최대 길이
        dec = 1  # 감소구간 길이 초기화
    elif nList[i] > nList[i+1]:  # 감소
        dec += 1
        ans = max(ans, dec)
        inc = 1
    else:  # 같은 때. 둘 다 늘려주고 비교
        inc += 1
        ans = max(ans, inc)
        dec += 1
        ans = max(ans, dec)
print(ans)
