import sys
input = sys.stdin.readline

for _ in range(int(input())):
    s = input().rstrip()
    a = s.count('A')
    b = s.count('B')
    c = s.count('C')
    if a+c == b:
        print('YES')
    else:
        print('NO')