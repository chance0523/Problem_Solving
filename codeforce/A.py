import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())       
    print('()'*n)
    if n >= 2:
        for i in range(2,n+1):
            s = '(' * i + ')' * i + '()'* (n-i)
            print(s)