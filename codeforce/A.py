import sys
input = sys.stdin.readline

for _ in range(int(input())):
    d = {}
    s1 = input().rstrip()
    for i in range(26):
        d[s1[i]] = i+1
    s2 = input().rstrip()
    sList = []
    for i in range(len(s2)):
        sList.append(d[s2[i]])
    ans = 0
    for i in range(len(sList)-1):
        ans += abs(sList[i] - sList[i+1])
    print(ans)