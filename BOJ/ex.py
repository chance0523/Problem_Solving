'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


limit = int(input())
speed = int(input())
d = speed - limit
if d <= 0:
    print("Congratulations, you are within the speed limit!")
elif d >= 1 and d <= 20:
    print("You are speeding and your fine is ${}.".format(100))
elif d >= 21 and d <= 30:
    print("You are speeding and your fine is ${}.".format(270))
elif d >= 31:
    print("You are speeding and your fine is ${}.".format(500))