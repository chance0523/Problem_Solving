import sys
input = sys.stdin.readline


t = int(input())


def func(p, f, cnts, cntw, s, w):
    ans = 0

   # I
    if p >= cnts*s:  # I can buy all swords
        ans += cnts
        p -= cnts*s
        cnts = 0
    else:  # not all
        if p < s:  # cannot buy
            pass
        else:  # can buy
            num = p//s  # amounts
            ans += num
            p -= num*s
            cnts -= num

    if p > 0:
        if p >= cntw*w:  # I can buy all swords
            ans += cntw
            p -= cntw*w
            cntw = 0
        else:  # not all
            if p < w:  # cannot buy
                pass
            else:  # can buy
                num = p//w  # amounts
                ans += num
                p -= num*w
                cntw -= num

    # follower

    if f >= cnts*s:  # I can buy all swords
        ans += cnts
        f -= cnts*s
        cnts = 0
    else:  # not all
        if f < s:  # cannot buy
            pass
        else:  # can buy
            num = f//s  # amounts
            ans += num
            f -= num*s
            cnts -= num
    if f > 0:
        if f >= cntw*w:  # I can buy all swords
            ans += cntw
            f -= cntw*w
            cntw = 0
        else:  # not all
            if f < w:  # cannot buy
                pass
            else:  # can buy
                num = f//w  # amounts
                ans += num
                f -= num*w
                cntw -= num
    global maxans
    if maxans < ans:
        maxans = ans


for _ in range(t):
    p, f = map(int, input().split())
    # You can carry at most p units and your follower — at most f units.
    # I = p , follower = f
    cnts, cntw = map(int, input().split())
    s, w = map(int, input().split())
    # swords, war axes

    maxans = 0

    func(p, f, cnts, cntw, s, w)
    func(f, p, cnts, cntw, s, w)
    func(p, f, cntw, cnts, w, s)
    func(f, p, cntw, cnts, w, s)
    print(maxans)
