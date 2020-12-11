import sys
input = sys.stdin.readline


def getCal(l):
    ret = 1
    for i in range(1, l):
        ret += 4 ** i
    return ret


def isContain():
    global ans
    lx = len(mList[0])
    ly = len(mList)
    curans = 0
    for i in range(n):
        for j in range(m):
            if j + lx > m or i + ly > n:
                continue
            flag = True
            for dy in range(ly):
                if not flag:
                    break
                for dx in range(lx):
                    if mList[dy][dx] == '*' and nList[i+dy][j+dx] == '.':
                        flag = False
                        break
                    # temp[i+dy][j+dx] = '.'
            if flag:
                ans += 1
    # print(ans)
    # print(curans)
    # if curans:
    #     ans += curans*getCal(len(mList))
    #     return True


for _ in range(int(input())):
    n, m = map(int, input().split())
    nList = [0 for i in range(n)]
    for i in range(n):
        nList[i] = list(input().rstrip())

    ans = 0
    for k in range(m-1, 0, -1):
        mList = [0 for _ in range(k)]
        for i in range(k):
            mList[i] = list('.' * ((k*2-1 - (i * 2 + 1)) // 2) +
                            '*' * (i * 2 + 1) + '.' * ((k * 2 - 1 - (i * 2 + 1)) // 2))

        # print(mList)
        isContain()

    print(ans)
