# 2812번. 크게 만들기


n, k = map(int, input().split())
initk = n-k
s = list(input())
ans = []

for i in range(len(s)):
    if k == 0:  # 모두 다 지웠으면 그 다음은 그냥 계속 넣어줌.
        ans.append(s[i])
        continue
    if not ans:  # 스택이 비어있으면 무조건 넣어준다
        ans.append(s[i])
    else:
        if ans[-1] >= s[i]:  # 더 작은수는 일단 넣어줌
            ans.append(s[i])
        else:  # 큰 수가 나오면 계속 pop하고 k--
            while ans and ans[-1] < s[i] and k > 0:
                ans.pop()
                k -= 1
            ans.append(s[i])

print(''.join(ans[:initk]))
