'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
nList = [list(map(int,input().rstrip().split())) for _ in range(n)]
nList.sort() # 이익이 최대인 가격 중 가장 낮은 가격 출력

prices = []
for i in range(n):
    prices.append(nList[i][0])

benefit = 0
ans = 0
for price in prices:
    temp = 0
    for j in range(n):
        if nList[j][0] >= price:
            if price - nList[j][1] > 0: # 세준이가 안 팔수도 있다
                temp += (price - nList[j][1])
    if benefit < temp:
        benefit = temp
        ans = price
print(ans)