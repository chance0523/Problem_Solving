import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,h =map(int,input().split())
    nList = list(map(int,input().rstrip().split()))
    nList.sort(reverse=True)
    if h - nList[0] <= 0:
        print(1)
        continue
    if h - nList[0] - nList[1] <= 0:
        print(2)
        continue
    a = nList[0] + nList[1]
    cnt = (h // a)*2
    if h%a != 0:
        if (h%a) - nList[0] <=0:
            cnt += 1
        elif (h%a) - nList[0] - nList[1] <= 0:
            cnt+= 2
    print(cnt)
    