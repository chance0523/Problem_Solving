import sys
input = sys.stdin.readline

n = int(input())
sList = list(input().rstrip().split())

# 팰린드롬은 시작과 끝 문자가 같다.
# s[0]과 s[-1]은 항상 같음
# sList의 s[0]가 다 같으면 끝말잇기 성공

ans = 1  # 문자열이 하나라면 끝말잇기 성공
val = sList[0][0]
for i in range(1, n):
    if sList[i][0] == val:
        ans = 1
    else:
        ans = 0
        break
print(ans)
