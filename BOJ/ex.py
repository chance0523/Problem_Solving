'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

nList = [int(input()) for _ in range(4)]
r = 0
for i in range(3):
    if nList[i+1] > nList[i]:
        r += 1
    elif nList[i+1] < nList[i]:
        r -= 1

if len(set(nList)) == 1: 
    print("Fish At Constant Depth")
elif r == 3:
    print("Fish Rising")
elif r == -3:    
    print("Fish Diving")
else:
    print("No Fish")