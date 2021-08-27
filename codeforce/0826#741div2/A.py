import sys
input = sys.stdin.readline

for _ in range(int(input())):
    l,r = map(int,input().rstrip().split())
    if r//l == 1:
        print(r%l)
    else:
        m = r//2+1
        print(r%m)