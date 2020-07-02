import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    a, b, n, m = map(int, input().split())
    # 첫번째 타입 : 더 많은걸 먹는다. (같으면 초콜릿)
    # 두번째 타입 : 더 적은걸 먹는다. (같으면 바닐라)
    if a+b < n+m:
        print('No')
        continue
    else:
        if a <= b:
            diff = b-a
