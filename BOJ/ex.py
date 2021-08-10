import sys

sys.setrecursionlimit(10**8)

import math


def game(cur, turn, dp):
    if turn:
        if cur == k:
            return False
        elif cur == k - 1:
            return True
        result = 0
    else:
        if cur == k:
            return True
        elif cur == k - 1:
            return False
        result = 1

    if (dp[cur][turn] != -1):
        return dp[cur][turn]

    for i in range(1, int(math.sqrt(cur)) + 1):
        if cur % i == 0:
            if turn:
                if cur + i <= k:
                    result |= game(cur + i, 0, dp)
                else:
                    break
            else:
                if cur + i <= k:
                    result &= game(cur + i, 1, dp)
                else:
                    break
    if turn:
        if cur + cur <= k:
            result |= game(cur + cur, 0, dp)
    else:
        if cur + cur <= k:
            result &= game(cur + cur, 1, dp)

    dp[cur][turn] = result

    return dp[cur][turn]


k = int(input())
dp = [[-1, -1] for j in range(k + 1)]
ans = game(1, 1, dp)
if ans:
    print('Kali')
else:
    print('Ringo')