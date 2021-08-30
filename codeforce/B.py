import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    aList = list(map(int,input().rstrip().split()))
    odd,even = 0,0
    for j in range(n):
        if aList[j] % 2 == 0:
            aList[j] = 0
            even += 1
        else:
            aList[j] = 1
            odd += 1

    if abs(even-odd) >= 2:
        print(-1)
        continue

    temp1 = [i*2 for i in range(n)]
    temp2 = [i*2+1 for i in range(n)]

    n1 = []
    for i in range(n):
        if aList[i] == aList[0]:
            n1.append(i)
    
    ans1 = 0
    for i in range(len(n1)):
        ans1 += abs(temp1[i] - n1[i])
    
    ans2 = 0
    for i in range(len(n1)):
        ans2 += abs(temp2[i] - n1[i])
    print(aList)
    print(temp1)
    print(temp2)
    print(n1)
    print(min(ans1,ans2))

'''
010101
101010
101100
'''

'''
0101010
1010101
0111100
0101101
'''