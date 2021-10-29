'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n = int(input())
ans = 0
# 선끼리 교차하지 않으려면 스택으로 바로바로...
for _ in range(n):
    s = input().rstrip()
    stack = []
    for i in range(len(s)):
        if not stack: # 스택이 비어있으면 일단 넣어준다
            stack.append(s[i])
        else:
            if stack[-1] == s[i]: # 스택의 top과 같으면 pop
                stack.pop()
            else:
                stack.append(s[i]) # 아니면 넣어준다
    if not stack: # 스택이 비어있으면 좋은 단어
        ans += 1
print(ans)