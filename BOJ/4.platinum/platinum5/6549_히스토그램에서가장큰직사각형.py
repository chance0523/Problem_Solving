# 6549번. 히스토그램에서 가장 큰 직사각형


import sys
input = sys.stdin.readline


def fun(l, r):
    if l == r:
        return hList[l]
    else:
        m = (l + r) // 2
        nl = m
        nr = m + 1
        nh = min(hList[nl], hList[nr])
        tmp = nh * 2

        cnt = 2
        while True:
            if (hList[nl] == 0 or nl == l) and (hList[nr] == 0 or nr == r):
                break
            elif hList[nl] == 0 or nl == l:
                if hList[nr + 1] < nh:
                    nh = hList[nr + 1]
                nr += 1
            elif hList[nr] == 0 or nr == r:
                if hList[nl - 1] < nh:
                    nh = hList[nl - 1]
                nl -= 1
            else:
                if hList[nl - 1] > hList[nr + 1]:
                    if hList[nl - 1] < nh:
                        nh = hList[nl - 1]
                    nl -= 1
                else:
                    if hList[nr + 1] < nh:
                        nh = hList[nr + 1]
                    nr += 1
            cnt += 1
            tmp = max(tmp, nh * cnt)
        return(max(fun(l, m), fun(m + 1, r), tmp))


while True:
    hList = list(map(int, input().split()))
    n = hList[0]
    if n == 0:
        break
    print(fun(1, len(hList) - 1))
