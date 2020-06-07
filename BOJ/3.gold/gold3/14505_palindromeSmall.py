# 14505번. 팰린드롬 개수 구하기 (Small)


import sys
input = sys.stdin.readline

# 참고 블로그 : https://www.crocus.co.kr/869

# dp[a][b] : a에서 b까지 인덱스의 단어중
# 팰린드롬이 되는 가짓수

s = input().rstrip()
dp = [[0 for i in range(1005)] for i in range(1005)]

# 일단 기본적인 전처리
for i in range(len(s)):
    # 한 글자 (a)
    dp[i][i] = 1

    if i != len(s)-1:
        # aa -> a, a, aa
        if s[i] == s[i+1]:
            dp[i][i+1] = 3

        # ab -> a, b
        else:
            dp[i][i+1] = 2


for i in range(len(s)):
    for left in range(len(s)):
        right = left+i  # left <- i만큼의 길이 -> right

        if right >= len(s):
            break

        # 위의 블로그 참고
        dp[left][right] = dp[left+1][right] + \
            dp[left][right-1]-dp[left+1][right-1]

        # 블로그 참고
        if s[left] == s[right]:
            dp[left][right] += dp[left+1][right-1]+1

print(dp[0][len(s)-1])
