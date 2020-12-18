# 4796번. 캠핑


import sys
input = sys.stdin.readline


cnt = 1
while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:  # 종료조건
        break
    ans = 0

    ans += (v // p)*l  # 이만큼의 덩어리들이 들어감
    remain = v - (v // p) * p  # 이만큼이 남음
    ans += min(remain, l)  # 남은 날짜와 p중에 더 작은 것을 더해줌

    print(f'Case {cnt}: {ans}')  # 출력
    cnt += 1
