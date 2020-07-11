import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    divs = []
    # 약수 구하기
    for i in range(1, int(n**0.5)+1):
        if n % i == 0:
            divs.append(i)
            if i != n//i:
                divs.append(n//i)
    divs.sort()
    # 자기자신을 제외한 가장 큰 약수
    a = divs[-2]
    b = n-divs[-2]
    print(min(a, b), max(a, b))
