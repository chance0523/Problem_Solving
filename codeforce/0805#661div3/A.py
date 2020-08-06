import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    if(len(nList) == 1):
        print("YES")
    else:
        nList.sort()
        flag = True
        for i in range(n-1):
            if(nList[i+1]-nList[i] >= 2):
                flag = False
                break
        if(flag):
            print('YES')
        else:
            print('NO')
