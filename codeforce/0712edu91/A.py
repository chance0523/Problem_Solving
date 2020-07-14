import sys
input = sys.stdin.readline

t = int(input())


def func():
    for i in range(1, n-1):
        if nList[i] > nList[i-1] and nList[i] > nList[i+1]:
            print("YES")
            print(i, i+1, i+2)
            return
    return print('NO')


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))

    func()
