import sys
input = sys.stdin.readline


for _ in range(int(input())):
    a, b, c = map(int, input().split())
    s = a + b + c
    # 6+3+6+3
    k = s // 9
    if a > k and b > k and c > k and s % 9 == 0:
        print('YES')
    else:
        print('NO')
