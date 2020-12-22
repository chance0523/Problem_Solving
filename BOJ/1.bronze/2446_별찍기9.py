# 2446번. 별찍기-9


'''
한 줄 씩 줄였다가 늘려가면서 출력할 수도 있지만
n이 작아서 그냥 리스트에 담고 n까지 출력했다가 거꾸로 돌아오면서 출력
'''
n = int(input())
ans = []
for i in range(n, 0, -1):
    ans.append(' '*(n-i) + '*' * (2 * i - 1))

for i in range(n):
    print(ans[i])
for i in range(n-2, -1, -1):
    print(ans[i])
