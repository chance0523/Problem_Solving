'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

s = input().rstrip()
nList = [input().rstrip() for _ in range(int(input()))]
nList.sort()
ansP = 0
ans = nList[0]
for i in range(len(nList)):
    L = s.count('L') + nList[i].count('L')
    O = s.count('O') + nList[i].count('O')
    V = s.count('V') + nList[i].count('V')
    E = s.count('E') + nList[i].count('E')
    p = ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100
    if ansP < p:
        ansP = p
        ans = nList[i]
print(ans)