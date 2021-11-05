'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
cList = [int(input().rstrip()) for _ in range(n)]
cList.sort(reverse=True) # 그냥 큰것들 묶어서 구매

ans = 0

for i in range(n):
    if i%3==0:
        ans += cList[i]
    elif i%3==1:
        ans += cList[i]
    else: # 공짜
        pass
print(ans)