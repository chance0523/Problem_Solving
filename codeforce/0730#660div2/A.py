import sys
input = sys.stdin.readline


t = int(input())

# 2 3 5 7 11
# 6 10 14 15 21 22
# 6+10+14 = 30
# 10+14+15 = 39
for _ in range(t):
    n = int(input())
    if(n <= 30):
        print('NO')
    elif(n == 36):
        print('YES')
        print(6, 10, 15, 5)
    elif(n == 40):
        print('YES')
        print(10, 14, 15, 1)
    elif(n == 44):
        print('YES')
        print(10, 14, 15, 5)
    else:
        print('YES')
        print(6, 10, 14, n-30)
