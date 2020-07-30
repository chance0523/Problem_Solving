import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, k, z = map(int, input().split())
    nList = list(map(int, input().split()))
    flag = True
    sList = sorted(nList, reverse=True)[:z]
    score = 0
    score1 = 0
    score2 = 0
    score3 = 0
    score4 = 0
    score5 = 0
    score6 = 0
    cnt = 0  # for z
    idx = 0
    move = 0
    while True:
        if(move == k):
            score += nList[idx]
            break
        else:
            score += nList[idx]
            if(cnt != z):
                if nList[idx] in sList:
                    score += nList[idx+1]
                    move += 1
                    score += nList[idx]
                    move += 1
                    cnt += 1
            move += 1
            idx += 1

    print(score)
