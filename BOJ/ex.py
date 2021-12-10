'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

nList = list(map(int,input().rstrip().split()))
nList.sort()
a,b,c = nList[0], nList[1], nList[2]
if a**2 + b**2 == c**2:
    print(1)
elif a == b == c:
    print(2)
else:
    print(0)
