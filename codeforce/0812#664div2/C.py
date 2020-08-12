import sys
input = sys.stdin.readline


n, m = map(int, input().split())
aList = list(map(int, input().split()))
bList = list(map(int, input().split()))

aList.sort()
bList.sort(reverse=True)

if 0 in bList:
    print(0)
else:


print(aList)
print(bList)
