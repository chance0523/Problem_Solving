'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


'''
홀수가 하나라도 있으면 홀수끼리 곱한 것이 답이다
짝수만 있으면 짝수끼리 곱한 것이 답
'''

nList = list(map(int,input().rstrip().split()))
odd = []
for i in range(3):
    if nList[i] % 2 != 0:
        odd.append(nList[i])

if odd:
    ans = 1
    for i in range(len(odd)):
        ans *= odd[i]
    print(ans)
else:
    ans = 1
    for i in range(len(nList)):
        ans *= nList[i]
    print(ans)