'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n,m = map(int,input().split())
flag = True
for i in range(m):
    k = int(input())
    kList = list(map(int,input().rstrip().split()))
    for j in range(k-1):
        # 아래에 있는 책이 더 작은 숫자라면 꺼낼수가 없다.
        if kList[j] < kList[j+1]:
            flag = False
if flag:
    print('Yes')
else:
    print('No')