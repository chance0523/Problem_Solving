'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

N, A, B, C, D = map(int, input().split())
A = (N//A + (1 if N%A else 0))*B
C = (N//C + (1 if N%C else 0))*D

print(min(A, C))