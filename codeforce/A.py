import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    aList = [0]+list(map(int, input().rstrip().split()))
    bList = [0]+list(map(int, input().rstrip().split()))
    cList = [0]+list(map(int, input().rstrip().split()))
    ans = [0, aList[1]]

    for i in range(1, n):
        if ans[i] != aList[i+1]:
            ans.append(aList[i+1])
        elif ans[i] != bList[i+1]:
            ans.append(bList[i+1])
        elif ans[i] != cList[i+1]:
            ans.append(cList[i+1])
    if ans[-1] == ans[1]:
        ans.pop()
        if aList[-1] != ans[1] and aList[-1] != ans[-1]:
            ans.append(aList[-1])
        elif bList[-1] != ans[1] and bList[-1] != ans[-1]:
            ans.append(bList[-1])
        elif cList[-1] != ans[1] and cList[-1] != ans[-1]:
            ans.append(cList[-1])
    print(*ans[1:])
