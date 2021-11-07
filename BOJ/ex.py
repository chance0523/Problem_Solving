'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

def isPalindrome(n):
    s1 = str(n)
    s2 = s1[::-1]
    if s1 == s2:
        return True
    else:
        return False

def isPrime(n):
    for i in range(2, int(n**0.5)+1):
        if n%i==0:
            return False
    return True

a,b = map(int,input().split())
if b>11111111:
    b = 11111111
for i in range(a, b+1):
    if isPalindrome(i) and isPrime(i):
        print(i)
print(-1)
