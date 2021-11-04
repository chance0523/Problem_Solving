'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

# 유클리드 호제법
def gcd(a,b) :
    while b > 0 :
        a, b = b, a%b
    return a

n = int(input())
nList = list(map(int,input().rstrip().split()))
m = int(input())
mList = list(map(int,input().rstrip().split()))

a = 1
b = 1
for i in range(n):
    a *= nList[i]
for i in range(m):
    b *= mList[i]

ans = gcd(a,b)
print('%s'%str(ans)[-9:])