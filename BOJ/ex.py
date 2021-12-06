'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

an = int(input())
eye = int(input())
ans = []
if an >= 3 and eye <= 4:
    ans.append('TroyMartian')
if an <= 6 and eye >= 2:
    ans.append('VladSaturnian')
if an <= 2 and eye <= 3:
    ans.append('GraemeMercurian')

if ans:
    for a in ans:
        print(a)
    