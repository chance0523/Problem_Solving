import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    s = list(input().rstrip())
    turn = False  # F for Alice, T for Bob
    i = 0
    while True:
        # if s empty
        if not s:
            break
        # all 0
        if '1' not in s:
            break
        # all 1
        if '0' not in s:
            break
        if s[i] != s[i+1]:
            del s[i:i+2]
            i = 0
            turn = not turn
        else:
            i += 1
    # print(turn)
    if turn:
        print('DA')
    else:
        print('NET')
