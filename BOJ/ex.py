'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
if n == 0:
    print('divide by zero')
else:
    nList = list(map(int,input().rstrip().split()))
    ans = sum(nList)/n / (sum(nList)/n)
    print("%.2f" % ans)