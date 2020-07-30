import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    # if it is good
    # arr[i] = arr[i-2]
    s = list(input().rstrip())
    numList = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(len(s)):
        numList[int(s[i])] += 1
    # print(numList)
    flag = False
    maxnum = max(numList)
    maxidx = numList.index(maxnum)
    ans = 0
    l = len(s)
    while True:
        if flag:
            print(ans)
            break
        else:
            flag = True
            for i in range(l):
                if s[i] != s[i-2]:
                    s.pop(i+2)
                    l -= 1
                    ans += 1
                    flag = False
                    print(s)
                    break
''' 
000013
'''
