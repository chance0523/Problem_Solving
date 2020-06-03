# 17626번. Four Squares


import sys
input = sys.stdin.readline

n = int(input())
ans = 4  # 최대값은 4
for i in range(int(n**0.5), int((n//4)**0.5), -1):
    if i**2 == n:
        ans = 1
        break
    else:
        tmp = n-i**2  # i^2을 빼고 남은 수를 생각
        for j in range(int(tmp**0.5), int((tmp//3)**0.5), -1):
            if i**2+j**2 == n:
                ans = min(ans, 2)
                continue
            else:
                tmp = n-i**2-j**2
                for k in range(int(tmp**0.5), int((tmp//2)**0.5), -1):
                    if n == i**2+j**2+k**2:
                        ans = min(ans, 3)
print(ans)
