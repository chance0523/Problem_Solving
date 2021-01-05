import sys
input = sys.stdin.readline


for _ in range(int(input())):
    w, h, n = map(int, input().split())
    if n == 1:
        print('YES')
        continue
    if w % 2 and h % 2:
        print('NO')
        continue
    l = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192]
    a = 1
    b = 1
    while True:
        if w % 2 or w == 1:
            break
        w //= 2
        a *= 2
    while True:
        if h % 2 or h == 1:
            break
        h //= 2
        b *= 2
        
    if a * b >= n:
        print('YES')
    else:
        print('NO')
